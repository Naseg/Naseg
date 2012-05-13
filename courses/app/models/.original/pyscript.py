import os
import re

line_patterns = ["import",
                 "@Basic",
                 "@XmlRootElement",
                 "@XmlTransient",
                 "@GeneratedValue",
                 "@Temporal",
                 "@NamedQueries",
                 "@NamedQuery"
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
         "Collection" : "Set",
         "studentsSet2" : "studentsAdvisored"}

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
    public static int AcademicYear()
    {
      int currentYear = -1;
      for (Course c : Course.find.all())
            if (c.academicYear > currentYear)
                currentYear = c.academicYear;
      return currentYear;
    }

    public Supervisor getProfessor()
    {
      Supervisor s = this.professor;
      String a = s.firstName; //does nothing, force fetching from db
      return s;
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

    public Set<Student> getStudentsAdvisored()
    {
      Set<Student> students = this.studentsAdvisored;
      for (Student s : students) { String a = s.firstName; } //do nothing, force fetching from db
      return students;
    }
""")
    if (filename == "UsersCredentials.java"):
        stream.write(
"""
    public static UserCredentials authenticate(String username, String password) {
        return find.where()
            .eq("userName", username)
            .eq("password", password)
            .findUnique();
    }

    public Student getStudent()
    {
      if (this.studentsSet.size() > 1)
      {
	throw new PersistenceException("There is more than one student for credential "+this);
      }
      else
      {
	try {
	  return (Student)this.studentsSet.toArray()[0];
	}
	catch (ArrayIndexOutOfBoundsException ex) {
	  return null;
	}
      }
    }

    public Supervisor getSupervisor()
    {
      if (this.supervisorsSet.size() > 1)
      {
	throw new PersistenceException("There is more than one supervisor for credential "+this);
      }
      else
      {
	try {
	  return (Supervisor)this.supervisorsSet.toArray()[0];
	}
	catch (ArrayIndexOutOfBoundsException ex) {
	  return null;
	}
      }
    }
""")
    if (filename == "Students.java"):
        stream.write(
"""
    public Set<CourseEnrollment> getCoursesEnrollmentSet()
    {
      Set<CourseEnrollment> enrollments = this.coursesEnrollmentSet;
      for (CourseEnrollment c : enrollments) {Integer s = c.credits;} //does nothing, force fetching from db
      return enrollments;
    }

    public List<Course> getStudyPlan()
    {
      Set<CourseEnrollment> enrollments = this.getCoursesEnrollmentSet();
      List<Course> studyPlan = new ArrayList();
      int currentYear = Course.AcademicYear();
      for (CourseEnrollment enrollment : enrollments)
      {
	if (enrollment.getCourse().academicYear == currentYear)
	{
	  studyPlan.add(enrollment.getCourse());
	}
      }
      return studyPlan;
    }
""")
    if (filename == "CoursesEnrollments.java"):
        stream.write(
"""
    public Course getCourse()
    {
      Course c = this.course;
      Integer a = c.credits; //does nothing, force fetching from db
      return c;
    }

    public static List<Course> enrollmentsToCourses(Set<CourseEnrollment> enrollments)
    {
      List<Course> out = new ArrayList();
      for (CourseEnrollment enrollment : enrollments)
	out.add(enrollment.getCourse());
      return out;
    }
""")
    stream.write("}\n")
    stream.close()
    #print(files[filename])
#print([k for k in files])


