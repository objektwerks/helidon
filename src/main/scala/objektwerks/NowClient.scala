package objektwerks

import io.helidon.webclient.api.WebClient

object NowClient:
  @main def runNowClient: Unit =
    val client = WebClient
      .builder
      .baseUri(Conf.url)
      .build

    val now = client
      .get
      .request
      .entity
      .as(classOf[String])
    println(s"*** Now Client get: ${Conf.url}")
    println(s"$now")