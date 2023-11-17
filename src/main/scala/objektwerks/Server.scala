package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
@main def runServer: Unit =
  val nowHandler = NowHandler()

  val router = HttpRouting
    .builder
    .get(NowConfig.endpoint, nowHandler)

  WebServer
    .builder
    .port(NowConfig.port)
    .routing(router)
    .build
    .start

  println( NowClient.get(NowConfig.url ))

  Thread.currentThread.join