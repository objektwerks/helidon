package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

/**
  * WebServer appears to set port incorrectly, always returning -1.
  */
object Server extends LazyLogging:
  @main def runServer(): Unit =
    val config = Config.create()
    val host = config.get("server.host").asString().get()
    val port = config.get("server.port").asInt().get()
    logger.info(s"*** Config host: $host port: $port")

    val routing = HttpRouting
      .builder()
      .get("/now", (request, response) => response.send(Instant.now.toString))

    val server = WebServer
      .builder()
      .host(host)
      .port(port)
      .routing(routing)
      .build()

    logger.info(s"*** Helidon WebServer port: ${server.port()}")
    logger.info(s"*** Server running @ $host:$port")

    sys.addShutdownHook {
      logger.info(s"*** Server stopping @ $host:$port")
      server.stop()
    }

    Thread.currentThread().join()