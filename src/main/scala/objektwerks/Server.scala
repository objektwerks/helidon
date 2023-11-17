package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
@main def runServer: Unit =
  val handler = NowHandler()

  val builder = HttpRouting
    .builder
    .get(handler.endpoint, handler)

  WebServer
    .builder
    .port( NowConf.port )
    .routing(builder)
    .build
    .start

  println( NowClient.get( NowConf.url ) )

  Thread.currentThread.join