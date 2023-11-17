package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
@main def runNowServer: Unit =
  val handler = NowHandler()

  val builder = HttpRouting
    .builder
    .get(handler.endpoint, handler)

  WebServer
    .builder
    .config(Conf.config)
    .routing(builder)
    .build
    .start

  println( NowClient.call() )

  Thread.currentThread.join