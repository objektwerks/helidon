package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*
import com.github.plokhotnyuk.jsoniter_scala.macros.*

final case class Event(name: String = "event")

object Event:
  given JsonValueCodec[Event] = JsonCodecMaker.make[Event]