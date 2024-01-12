package objektwerks

import io.helidon.logging.common.LogConfig
import io.helidon.webserver.WebServer

import org.slf4j.LoggerFactory
  
@main def runServer: Unit =
  LogConfig.configureRuntime()
  val logger = LoggerFactory.getLogger("app")
  logger.info("Server initializing ...")

  
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

  logger.info("Server initialized.")
  println( Client.get(Conf.url, Conf.nowEndpoint) )
  println( Client.post(Command("run command"), Conf.url, Conf.commandEndpoint) )

  Thread.currentThread.join