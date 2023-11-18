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

  println( Client.get(Conf.url, Conf.nowEndpoint) )
  println( Client.post(Command("run command"), Conf.url, Conf.commandEndpoint) )

  Thread.currentThread.join