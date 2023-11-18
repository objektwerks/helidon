package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*

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

  def post(command: Command, url: String): Event =
    val commandJson = writeToString[Command](command)

    val eventJson = WebClient
      .builder
      .baseUri(url)
      .build
      .post(commandJson)
      .request
      .entity
      .as(classOf[String])
    
    readFromString[Event](eventJson)
