package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*

import io.helidon.webserver.http.{Handler, ServerRequest, ServerResponse}

final class CommandHandler() extends Handler:
  override def handle(request: ServerRequest,
                      response: ServerResponse): Unit =
    val commandJson = request.content.as(classOf[String])
    val command = readFromString[Command](commandJson)
    println(s"*** Command: $command")

    val event = Event("test")
    val eventJson = writeToString[Event](event)
    println(s"*** Event: $eventJson")
    response.send(eventJson)