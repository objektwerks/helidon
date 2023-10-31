Helidon
-------
>Helidon feature tests using Scala 3.

Note
----
>WebServer appears to set port incorrectly, always returning -1.

>Consequently Curl and Client fail to connect to http://localhost:7979/now

Run
---
1. sbt clean compile run
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.runClient
 [2] objektwerks.runServer

Enter number:
```

Curl
----
1. curl -v http://localhost:7979/now

Reference
---------
