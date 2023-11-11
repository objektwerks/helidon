package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}

import java.time.Instant

import scala.sys.process.Process
import io.helidon.webserver.http.ServerRequest
import io.helidon.webserver.http.ServerResponse

final class NowHandler extends Handler:
  override def handle(request: ServerRequest,
                      response: ServerResponse): Unit = response.send(s"*** Datetime: ${Instant.now.toString}")
  
object Server:
  @main def runServer: Unit =
    val config = Config.create.get("server")
    val url = config.get("url").asString.get
    val endpoint = config.get("endpoint").asString.get

    val handler = NowHandler()

    val routing = HttpRouting
      .builder
      .get(endpoint, handler)

    WebServer
      .builder
      .config(config)
      .routing(routing)
      .build
      .start

    Process(s"curl $url").run.exitValue

    Thread.currentThread.join