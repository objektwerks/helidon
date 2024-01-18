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

  private def cors(): CorsSupport =
    CorsSupport
      .builder()  
      .addCrossOrigin(
        CrossOriginConfig
          .builder()
          .allowCredentials(true)
          .allowHeaders("*")
          .allowMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
          .allowOrigins("http://localhost")
          .build()
      ) 
      .addCrossOrigin(CrossOriginConfig.create())
      .build()