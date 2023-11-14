enablePlugins(DockerPlugin, GraalVMNativeImagePlugin)

lazy val dockerAppName = "now"
lazy val dockerImageName = "helidon-server"
lazy val dockerHubName = "objektwerks"
lazy val dockerAppVersion = "0.4"

name := "helidon"
organization := "objektwerks"
version := dockerAppVersion
scalaVersion := "3.3.1"
libraryDependencies ++= {
  val helidonVersion = "4.0.0"
  Seq(
    "io.helidon.webserver" % "helidon-webserver" % helidonVersion,
    "io.helidon.webclient" % "helidon-webclient" % helidonVersion,
    "io.helidon.config" % "helidon-config-yaml" % "4.0.0",
    "ch.qos.logback" % "logback-classic" % "1.4.11"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)