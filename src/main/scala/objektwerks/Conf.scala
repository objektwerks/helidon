package objektwerks

import io.helidon.config.Config

object Conf:
  val config = Config.create

  val port = config.get("server").get("port").asInt.get
  val url = config.get("server").get("url").asString.get

  val nowEndpoint = config.get("now").get("endpoint").asString.get

  val commandEndpoint = config.get("command").get("endpoint").asString.get