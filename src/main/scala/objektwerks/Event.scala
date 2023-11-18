package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*
import com.github.plokhotnyuk.jsoniter_scala.macros.*

final case class Event(name: String)

object Event:
  given JsonValueCodec[Event] = JsonCodecMaker.make[Event]