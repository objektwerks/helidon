package objektwerks

import io.helidon.webserver.http.{Handler, ServerRequest, ServerResponse}

import java.time.Instant

final class NowHandler() extends Handler:
  override def handle(request: ServerRequest,
                      response: ServerResponse): Unit =
    response
      .status(200)
      .header("Content-Type", "text/html; charset=UTF-8")
      .send(s"*** Now: ${Instant.now.toString}")