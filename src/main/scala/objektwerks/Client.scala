package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*

import io.helidon.webclient.api.WebClient

object Client:
  def get(url: String,
          endpoint: String): String =
    WebClient
      .builder
      .baseUri(url)
      .addHeader("Accept", "text/html")
      .build
      .get(endpoint)
      .request
      .entity
      .as(classOf[String])

  def post(command: Command,
           url: String,
           endpoint: String): Event =
    val commandJson = writeToString[Command](command)

    val eventJson = WebClient
      .builder
      .baseUri(url)
      .addHeader("Content-Type", "application/json; charset=UTF-8")
      .addHeader("Accept", "application/json")
      .build
      .post(endpoint)
      .submit(commandJson, classOf[String])
      .entity
    
    readFromString[Event](eventJson)