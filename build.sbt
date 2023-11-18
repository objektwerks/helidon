enablePlugins(DockerPlugin, GraalVMNativeImagePlugin)

lazy val dockerAppName = "now"
lazy val dockerImageName = "helidon-server"
lazy val dockerHubName = "objektwerks"
lazy val dockerAppVersion = "0.7"

name := "helidon"
organization := "objektwerks"
version := dockerAppVersion
scalaVersion := "3.3.1"
libraryDependencies ++= {
  val helidonVersion = "4.0.0"
  val jsoniterVersion = "2.24.4"
  Seq(
    "io.helidon.webserver" % "helidon-webserver" % helidonVersion,
    "io.helidon.webclient" % "helidon-webclient" % helidonVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "io.helidon.config" % "helidon-config-yaml" % "4.0.0",
    "ch.qos.logback" % "logback-classic" % "1.4.11"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

import com.typesafe.sbt.packager.docker._
import com.typesafe.sbt.packager.docker.DockerChmodType

Docker / packageName := dockerImageName
dockerExposedPorts ++= Seq(7979)
dockerBaseImage := "zulu-openjdk-alpine:21"
dockerCommands ++= Seq(
  Cmd("USER", "root"),
  ExecCmd("RUN", "apk", "add", "--no-cache", "bash"),
  ExecCmd("RUN", "apk", "add", "--no-cache", "curl")
)
dockerChmodType := DockerChmodType.UserGroupWriteExecute