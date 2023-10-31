name := "helidon"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1"
libraryDependencies ++= {
  Seq(
    "io.helidon.webserver" % "helidon-webserver" % "4.0.0",
    "com.typesafe" % "config" % "1.4.2",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.4.11"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)