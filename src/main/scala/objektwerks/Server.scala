package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
@main def runServer: Unit =
  val router = HttpRouting
    .builder
    .get(NowConfig.endpoint, NowHandler())

  WebServer
    .builder
    .port(NowConfig.port)
    .routing(router)
    .build
    .start

  println( Client.get(NowConfig.url) )

  Thread.currentThread.join