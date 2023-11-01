package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.webclient.api.WebClient

object Client extends LazyLogging:
  @main def runClient: Unit =
    val baseUrl = "http://localhost:7979"
    val endpoint = "/now"

    val client = WebClient
      .builder
      .baseUri(baseUrl)
      .build

    val response = client
      .get
      .path(endpoint)
      .request
    val now = response.entity

    logger.info(s"*** Client targeting: $baseUrl$endpoint")
    logger.info(s"*** Server response: ${now.toString}")