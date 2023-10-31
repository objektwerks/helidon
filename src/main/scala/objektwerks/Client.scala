package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.webclient.api.WebClient

object Client extends LazyLogging:
  val baseUrl = "http://localhost:7979"

  val client = WebClient
    .builder()
    .baseUri(baseUrl)
    .build()

  logger.info(s"*** Client targeting: $baseUrl")