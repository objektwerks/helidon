package objektwerks

import io.helidon.webserver.http.{Handler, ServerRequest, ServerResponse}

import java.time.Instant

final class NowHandler extends Handler:
  override def handle(request: ServerRequest,
                      response: ServerResponse): Unit = response.send(s"*** Now: ${Instant.now.toString}")