package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*

import io.helidon.webserver.http.{Handler, ServerRequest, ServerResponse}

final class CommandHandler() extends Handler:
  override def handle(request: ServerRequest,
                      response: ServerResponse): Unit =
    val json = request.content.as(classOf[String])
    val command = readFromString[Command](json)