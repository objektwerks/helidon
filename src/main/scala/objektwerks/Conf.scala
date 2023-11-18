package objektwerks

import io.helidon.config.Config

object Conf:
  val config = Config.create

  val port = config.get("server").get("port").asInt.get

  val nowEndpoint = config.get("now").get("endpoint").asString.get
  val nowUrl = config.get("now").get("url").asString.get