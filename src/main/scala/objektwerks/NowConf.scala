package objektwerks

import io.helidon.config.Config

object NowConf:
  val config = Config.create.get("now")
  val url = config.get("url").asString.get
  val endpoint = config.get("endpoint").asString.get