package objektwerks

import io.helidon.cors.CrossOriginConfig
import io.helidon.webserver.cors.CorsSupport
import io.helidon.webserver.http.HttpRouting
import io.helidon.webserver.http.HttpRouting.Builder

object Router:
  def build(): Builder = HttpRouting
    .builder
    .get(Conf.nowEndpoint, cors(), NowHandler())
    .post(Conf.commandEndpoint, cors(), CommandHandler())

  private def cors(): CorsSupport = CorsSupport.builder()  
    .addCrossOrigin(
      CrossOriginConfig
        .builder() 
        .allowOrigins("http://localhost")
        .allowMethods("GET", "POST") 
        .build()
    ) 
    .addCrossOrigin(CrossOriginConfig.create())
    .build()