package objektwerks

import io.helidon.config.Config
import io.helidon.webclient.api.WebClient

object NowClient:
  @main def runClient: Unit =
    val config = Config.create.get("server")
    val url = config.get("url").asString.get

    val client = WebClient
      .builder
      .baseUri(url)
      .build

    val now = client
      .get
      .request
      .entity
      .as(classOf[String])
    println(s"*** Now Client get: $url")
    println(s"$now")