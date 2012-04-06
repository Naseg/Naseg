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
         "CoursesEnrollments" : "CourseEnrollment",
         "Students" : "Student",
         "Universities" : "University",
         "Courses" : "Course",
         "Supervisors" : "Supervisor",
         "UsersCredentials" : "UserCredential",
         "FundingInstitutions" : "FundingInstitution",
         "UsersRoles" : "UserRole" }

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
                             '}',
                             files[filename],
                             flags=re.DOTALL)
    for pl in pl2s:
        files[filename] = files[filename].replace(pl,pl2s[pl])

    stream = open('../'+filename, 'w')
    stream.write(
"""package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;\n
""")
    stream.write(files[filename]+"\n")
    stream.close()
    #print(files[filename])
    

    
#print([k for k in files])


