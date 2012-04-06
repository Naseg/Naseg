import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "phdcourses"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.18"
    )
    
    val auth = PlayProject(
	appName + "-auth", appVersion, path = file("modules/auth")
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).dependsOn(auth)

}
