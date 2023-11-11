package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

import scala.sys.process.Process

object Server:
  @main def runServer: Unit =
    val config = Config.create.get("server")
    val url = config.get("url").asString.get
    val endpoint = config.get("endpoint").asString.get

    val routing = HttpRouting
      .builder
      .get(endpoint, (request, response) => response.send(s"*** Datetime: ${Instant.now.toString})"))

    WebServer
      .builder
      .config(config)
      .routing(routing)
      .build
      .start

    Process(s"curl $url").run.exitValue

    Thread.currentThread.join