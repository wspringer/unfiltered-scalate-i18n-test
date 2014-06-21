organization := "com.example"

name := "Unfiltered Scalate i18n Test"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "0.8.0",
  "net.databinder" %% "unfiltered-jetty" % "0.8.0",
  "org.fusesource.scalate" %% "scalate-core" % "1.6.1"
)

resolvers ++= Seq(
  "java m2" at "http://download.java.net/maven/2"
)
