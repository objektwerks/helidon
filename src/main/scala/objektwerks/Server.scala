package objektwerks

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

import io.helidon.webserver.WebServer

object Server extends LazyLogging:
  private val config = ConfigFactory.load("server.conf")
  private val host = config.getString("host")
  private val port = config.getInt("port")

  val server = WebServer
    .builder()
    .host(host)
    .port(port)
    .build()

  logger.info(s"Server running @ {$host:$port}")