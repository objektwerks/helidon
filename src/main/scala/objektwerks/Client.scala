package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.webclient.api.WebClient

object Client extends LazyLogging:
  val url = "http://localhost:7979/now"

  val client = WebClient
    .builder()
    .baseUri(url)
    .build()

  logger.info(s"*** Client targeting: $url")