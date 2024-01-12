package objektwerks

import io.helidon.webserver.observe.ObserveFeature
import io.helidon.webserver.observe.health.HealthObserver
import io.helidon.health.checks.HealthChecks

object Features:
  def healthChecks() =
    ObserveFeature
      .create(
        HealthObserver
          .builder()
          .useSystemServices(false)
          .addCheck(HealthChecks.deadlockCheck())
          .addCheck(HealthChecks.diskSpaceCheck())
          .addCheck(HealthChecks.heapMemoryCheck())
          .details(true)
          .build()
      )