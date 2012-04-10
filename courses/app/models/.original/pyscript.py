import os
import re

line_patterns = ["import",
                 "@Basic",
                 "@XmlRootElement",
                 "@XmlTransient",
                 "@GeneratedValue",
                 "@Temporal"
                 ]

pl2s = { "Students" : "Student",
         "Countries" : "Country",
         "Trips" : "Trip",
         "Enrollments" : "Enrollment",
         "Students" : "Student",
         "Universities" : "University",
         "Courses" : "Course",
         "Supervisors" : "Supervisor",
         "Users" : "User",
         "FundingInstitutions" : "FundingInstitution",
         "Roles" : "Role",
         "Collection" : "Set"}

regexs = [re.compile(r'/\*.*?\*/', flags=re.DOTALL),
          re.compile(r'public [\w<>]* set[\w]*\([\w\s<>]*\) \{.*?\}[\s]+',
                     flags=re.DOTALL),
          re.compile(r'public [\w<>]* get[\w]*\([\w\s]*\) \{.*?\}[\s]+',
                     flags=re.DOTALL),
          re.compile(r'public [\w<>]* get[\w]*\([\w\s]*\) \{.*?\}[\s]+',
                     flags=re.DOTALL),
          re.compile(r'^[\s]*package models;[\s]*',
                     flags=re.DOTALL),
          ]

def filt(line):
    for pattern in line_patterns:
        if pattern in line:
            return ''
    return line

files = {}
for filename in os.listdir('.'):
    if not filename.endswith("java"):
        continue
    #print(filename)
    stream = open(filename, 'r')
    #files[filename] = stream.read()
    files[filename] = \
        ''.join([filt(line) for line in stream])
    stream.close()

    a="""(files[filename], n )= re.subn(#r'/\*[.\n\r]*?\*/',
        r'/\*.*?\*/',
        '',
        files[filename],
        flags=re.DOTALL
        )"""
    for pattern in regexs:
        files[filename] = re.sub(pattern,
                                 '',
                                 files[filename]
                                 )
    files[filename] = re.sub(r'private', 'public', files[filename])
    files[filename] = re.sub(r'implements Serializable', 'extends Model', files[filename])
    files[filename] = re.sub(r'public %s\([\w\s,]*\) \{.*?\}[\s]+' % filename[:-5],  # .*?\}[\s]+' % filename[:-5],
                             '',
                             files[filename],
                             flags=re.DOTALL)
    files[filename] = re.sub(r'    @Override[\n\r\s]+public int hashCode.*$', #.*?\}[\s]+',
                             '',
                             files[filename],
                             flags=re.DOTALL)
    files[filename] = re.sub(r'    @Id[\n\r\s]+@NotNull', 
                             '    @Id',
                             files[filename],
                             flags=re.DOTALL)
    outputname = filename
    for pl in pl2s:
        files[filename] = files[filename].replace(pl,pl2s[pl])
        outputname = outputname.replace(pl,pl2s[pl])

    stream = open('../'+outputname, 'w')
    stream.write(
"""package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;\n
""")
    stream.write(files[filename])
    stream.write(
"""    public static Finder<Long,%s> find = new Finder(
      Long.class, %s.class
    );

    public static List<%s> all() {
      return find.all();
    }
  
    public static void create(%s %s) {
      %s.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
""" % (outputname[:-5],outputname[:-5],outputname[:-5],outputname[:-5],outputname[:-5].lower(),outputname[:-5].lower()))
    if (filename == "Courses.java"):
        stream.write(
"""
    public static List<Course> findCourseEnrolled(Set<CourseEnrollment> enrollments) {
      List<Course> out = new ArrayList();
      for (Course c : Course.find.all())
	for (CourseEnrollment e : enrollments)
	{
	  if (c.coursesEnrollmentSet.contains(e))
	    out.add(c);
	}
      return out;
    }
""")
    if (filename == "Supervisors.java"):
        stream.write(
"""
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Supervisor s: Supervisor.find.orderBy("lastName").findList()) {
            options.put(s.supervisorID.toString(), s.lastName);
        }
        return options;
    }
""")
    if (filename == "UsersCredentials.java"):
        stream.write(
"""
    public static UserCredentials authenticate(String username, String password) {
        return find.where()
            .eq("username", username)
            .eq("password", password)
            .findUnique();
    }
""")
    stream.write("}\n")
    stream.close()
    #print(files[filename])
    

    
#print([k for k in files])


