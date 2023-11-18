package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*
import com.github.plokhotnyuk.jsoniter_scala.macros.*

final case class Command(name: String = "command")

object Command:
  given JsonValueCodec[Command] = JsonCodecMaker.make[Command]