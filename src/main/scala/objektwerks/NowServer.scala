package objektwerks

import io.helidon.config.Config
import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}

import scala.sys.process.Process
  
object NowServer:
  @main def runNowServer: Unit =
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