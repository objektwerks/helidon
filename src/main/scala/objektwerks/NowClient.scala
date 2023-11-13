package objektwerks

import io.helidon.webclient.api.WebClient

object NowClient:
  def call(): String =
    WebClient
      .builder
      .baseUri(Conf.url)
      .build
      .get
      .request
      .entity
      .as(classOf[String])