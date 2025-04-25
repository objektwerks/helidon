enablePlugins(DockerPlugin, GraalVMNativeImagePlugin)

lazy val dockerAppName = "now"
lazy val dockerImageName = "helidon-server"
lazy val dockerHubName = "objektwerks"
lazy val dockerAppVersion = "0.12"

name := "helidon"
organization := "objektwerks"
version := dockerAppVersion
scalaVersion := "3.7.0-RC3"
libraryDependencies ++= {
  val helidonVersion = "4.2.0"
  val jsoniterVersion = "2.35.2"
  Seq(
    "io.helidon.webserver" % "helidon-webserver" % helidonVersion,
    "io.helidon.webclient" % "helidon-webclient" % helidonVersion,
    "io.helidon.webserver" % "helidon-webserver-cors" % helidonVersion,
    "io.helidon.webserver.observe" % "helidon-webserver-observe" % helidonVersion,
    "io.helidon.webserver.observe" % "helidon-webserver-observe-health" % helidonVersion,
    "io.helidon.health" % "helidon-health-checks" % helidonVersion,
    "io.helidon.webserver.observe" % "helidon-webserver-observe-info" % helidonVersion,
    "io.helidon.webserver.observe" % "helidon-webserver-observe-log" % helidonVersion,
    "io.helidon.webserver.observe" % "helidon-webserver-observe-metrics" % helidonVersion,
    "io.helidon.metrics" % "helidon-metrics-system-meters" % helidonVersion,
    "io.helidon.openapi" % "helidon-openapi" % helidonVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "io.helidon.config" % "helidon-config-yaml" % helidonVersion,
    "io.helidon.logging" % "helidon-logging-slf4j" % helidonVersion,
    "ch.qos.logback" % "logback-classic" % "1.5.18"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

import com.typesafe.sbt.packager.docker._
import com.typesafe.sbt.packager.docker.DockerChmodType

Docker / packageName := dockerImageName
dockerExposedPorts ++= Seq(7979)
dockerBaseImage := "zulu-openjdk-alpine:23"
dockerCommands ++= Seq(
  Cmd("USER", "root"),
  ExecCmd("RUN", "apk", "add", "--no-cache", "bash"),
  ExecCmd("RUN", "apk", "add", "--no-cache", "curl")
)
dockerChmodType := DockerChmodType.UserGroupWriteExecute
