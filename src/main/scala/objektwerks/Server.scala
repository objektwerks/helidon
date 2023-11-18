package objektwerks

import io.helidon.webserver.WebServer
import io.helidon.webserver.http.{Handler, HttpRouting}
  
@main def runServer: Unit =
  val router = HttpRouting
    .builder
    .get(Conf.nowEndpoint, NowHandler())
    .post(Conf.commandEndpoint, CommandHandler())

  WebServer
    .builder
    .port(Conf.port)
    .routing(router)
    .build
    .start

  println( Client.get(Conf.nowUrl) )
  println( Client.post(Command("test"), Conf.commandUrl) )

  Thread.currentThread.join