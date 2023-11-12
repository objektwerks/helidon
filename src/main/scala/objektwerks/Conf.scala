package objektwerks

import io.helidon.config.Config

object Conf:
  val config = Config.create.get("server")
  val url = config.get("url").asString.get
  val endpoint = config.get("endpoint").asString.get