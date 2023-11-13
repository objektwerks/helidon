package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
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

  println( NowClient.call() )

  Thread.currentThread.join