package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

object Server extends LazyLogging:
  @main def runServer(): Unit =
    val config = Config.create()
    val host = config.get("server.host").asString().get()
    val port = config.get("server.port").asInt().get()
    logger.info(s"*** Server config: $host:$port")

    val routing = HttpRouting
      .builder()
      .get("/now", (request, response) => response.send(Instant.now.toString))

    val server = WebServer
      .builder()
      .host(host)
      .port(port)
      .routing(routing)
      .build()

    logger.info(s"*** Server running @ $host:$port")

    sys.addShutdownHook {
      logger.info(s"*** Server stopping @ localhost:${server.port}")
      server.stop()
    }

    Thread.currentThread().join()