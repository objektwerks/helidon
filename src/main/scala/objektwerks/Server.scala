package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.HttpRouting

import java.time.Instant

object Server extends LazyLogging:
  val config = Config.create()

  val routing = HttpRouting
    .builder()
    .post("/now", (request, response) => { response.send(Instant.now.toString) } )

  val server = WebServer
    .builder()
    .config(config.get("server"))
    .routing(routing)
    .build()

  logger.info(s"Server running @ 127.0.0.1:${server.port}")