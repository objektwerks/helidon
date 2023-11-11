package objektwerks

import io.helidon.config.Config
import io.helidon.webclient.api.WebClient

object Client:
  @main def runClient: Unit =
    val config = Config.create.get("server")
    val url = config.get("url").asString.get

    val client = WebClient
      .builder
      .baseUri(url)
      .build
    println(s"*** Client get: $url")

    val now = client
      .get
      .request
      .entity
      .as(classOf[String])
    println(s"*** Server response: $now")