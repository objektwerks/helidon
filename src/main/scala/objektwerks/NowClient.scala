package objektwerks

import io.helidon.webclient.api.WebClient

object NowClient:
  def call(url: String): String =
    WebClient
      .builder
      .baseUri(url)
      .build
      .get
      .request
      .entity
      .as(classOf[String])