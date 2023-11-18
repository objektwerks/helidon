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
    println(command)
    println(commandJson)

    val eventJson = WebClient
      .builder
      .baseUri(url)
      .build
      .post
      .request
      .entity
      .as(classOf[String])
    
    readFromString[Event](eventJson)