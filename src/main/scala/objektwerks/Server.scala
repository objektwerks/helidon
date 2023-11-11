package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

object Server:
  @main def runServer: Unit =
    val config = Config.create

    val routing = HttpRouting
      .builder
      .get("/now", (request, response) => response.send(Instant.now.toString))

    val server = WebServer
      .builder
      .config(config.get("server"))
      .routing(routing)
      .build
      .start

    sys.addShutdownHook {
      server.stop
    }

    Thread.currentThread.join