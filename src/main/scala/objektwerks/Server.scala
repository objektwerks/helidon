package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

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

    Thread.currentThread.join