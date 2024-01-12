package objektwerks

import io.helidon.webserver.http.HttpRouting
import io.helidon.webserver.http.HttpRouting.Builder

object Router:
  def build(): Builder = HttpRouting
    .builder
    .get(Conf.nowEndpoint, NowHandler())
    .post(Conf.commandEndpoint, CommandHandler())