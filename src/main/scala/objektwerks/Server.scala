package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.net.InetAddress
import java.time.Instant

object Server extends LazyLogging:
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

    logger.info(s"*** Server started @ ${InetAddress.getLocalHost}:${server.port}")

    sys.addShutdownHook {
      server.stop
      logger.info("*** Server stopped.")
    }

    Thread.currentThread.join