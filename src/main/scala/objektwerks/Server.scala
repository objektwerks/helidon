package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

import scala.sys.process.Process

object Server:
  @main def runServer: Unit =
    val config = Config.create.get("server")

    val routing = HttpRouting
      .builder
      .get("/now", (request, response) => response.send(Instant.now.toString))

    WebServer
      .builder
      .config(config)
      .routing(routing)
      .build
      .start

    Process("curl -v http://localhost:7979/now").run.exitValue

    Thread.currentThread.join