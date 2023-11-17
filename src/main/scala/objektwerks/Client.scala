package objektwerks

import io.helidon.webclient.api.WebClient

object Client:
  def get(url: String): String =
    WebClient
      .builder
      .baseUri(url)
      .build
      .get
      .request
      .entity
      .as(classOf[String])