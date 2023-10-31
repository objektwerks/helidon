package objektwerks

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

import io.helidon.config.Config
import io.helidon.webserver.WebServer

object Server extends LazyLogging:
  val config = Config.create()
  val server = WebServer.create(routing, config.get("server"))

  logger.info(s"Server running @ ${server.host}:${server.port}")