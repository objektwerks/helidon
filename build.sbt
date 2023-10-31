name := "helidon"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1"
libraryDependencies ++= {
  val helidonVersion = "4.0.0"
  Seq(
    "io.helidon.webserver" % "helidon-webserver" % helidonVersion,
    "io.helidon.webclient" % "helidon-webclient" % helidonVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.4.11"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)