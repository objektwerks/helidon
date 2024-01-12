package objektwerks

import io.helidon.logging.common.LogConfig
import io.helidon.webserver.WebServer
  
@main def runServer: Unit =
  LogConfig.configureRuntime()
  
  WebServer
    .builder
    .port(Conf.port)
    .featuresDiscoverServices(false)
    .addFeature(Features.healthChecks())
    .addFeature(Features.metrics())
    .addFeature(Features.openapi())
    .routing(Router.build())
    .build
    .start

  println( Client.get(Conf.url, Conf.nowEndpoint) )
  println( Client.post(Command("run command"), Conf.url, Conf.commandEndpoint) )

  Thread.currentThread.join