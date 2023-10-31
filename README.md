Http Server
-----------
>Http server and client built using JDK 21, virtual threads and Scala 3.

Server
------
>See Server.
1. sbt clean compile run

Client
------
>See Client.
1. curl -v http://localhost:7979/now

Reference
---------
1. [Java HTTP Server and Virtual Threads](https://piotrminkowski.com/2022/12/22/java-http-server-and-virtual-threads/)
2. [Virtual Threads: JEPS 425](openjdk.org/jeps/425)
3. [Structured Concurrency: JEPS 428](openjdk.org/jeps/428)
4. [Loom](www.marcobehler.com/guides/java-project-loom)
5. [HttpServer Javadoc](https://download.java.net/java/early_access/panama/docs/api/jdk.httpserver/com/sun/net/httpserver/package-summary.html)
6. [Virtual Threads](https://github.com/objektwerks/virtual.threads)
