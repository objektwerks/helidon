package objektwerks

import com.typesafe.scalalogging.LazyLogging

import io.helidon.webclient.api.WebClient

object Client extends LazyLogging:
  @main def runClient: Unit =
    val baseUrl = "http://localhost:7979/now"

    val client = WebClient
      .builder
      .baseUri(baseUrl)
      .build
    
    logger.info(s"*** Client targeting: $baseUrl")

    val response = client
      .get
      .request
    val now = response.entity.as(classOf[String])

    logger.info(s"*** Server response: ${now.toString}")