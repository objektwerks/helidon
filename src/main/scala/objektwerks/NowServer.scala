package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}

import scala.sys.process.Process
  
object NowServer:
  @main def runNowServer: Unit =
    val handler = NowHandler()

    val routing = HttpRouting
      .builder
      .get(Conf.endpoint, handler)

    WebServer
      .builder
      .config(Conf.config)
      .routing(routing)
      .build
      .start

    Process(s"curl ${Conf.url}").run.exitValue

    Thread.currentThread.join