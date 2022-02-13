val scala3Version = "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Operon Scala-starter-project",
    version := "0.9.1",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
		  "com.novocode" % "junit-interface" % "0.11" % "test",
		  "io.operon" % "operon-runner" % "0.9.1-RELEASE"
	  )
  )
