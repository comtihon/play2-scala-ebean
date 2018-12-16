
name := "play2-scala-ebean"

version := "0.1"

scalaVersion := "2.12.8"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, PlayEbean)

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += filters
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.2"
libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "4.11"

// ebean + play won't work without this on latest jdk
libraryDependencies ++= Seq(
  "javax.xml.bind" % "jaxb-api" % "2.2.11",
  "com.sun.xml.bind" % "jaxb-core" % "2.2.11",
  "com.sun.xml.bind" % "jaxb-impl" % "2.2.11",
  "javax.activation" % "activation" % "1.1.1"
)

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"