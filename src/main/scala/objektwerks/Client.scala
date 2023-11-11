package objektwerks

import io.helidon.webclient.api.WebClient

object Client:
  @main def runClient: Unit =
    val baseUrl = "http://localhost:7979/now"

    val client = WebClient
      .builder
      .baseUri(baseUrl)
      .build
    println(s"*** Client get: $baseUrl")

    val now = client
      .get
      .request
      .entity
      .as(classOf[String])
    println(s"*** Server response: $now")