package objektwerks

import io.helidon.config.Config

object NowConfig:
  val config = Config.create.get("now")
  val endpoint = config.get("endpoint").asString.get
  val port = config.get("port").asInt.get
  val url = config.get("url").asString.get