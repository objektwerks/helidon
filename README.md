Helidon
-------
>Helidon app using Docker, JDK 23 GraalVM, Jsoniter and Scala 3.

Features
--------
>Currently configured features:
```[Config, Encoding, Health, Media, Metrics, Observe, OpenAPI, WebClient, WebServer]```

Issues
------
1. Logging does not work correctly --- with Helidon messages going to console, not ./target/server.log.
2. Metrics throws warnings. See Metrics section below.

Install
-------
>[GraalVM Getting Started](https://www.graalvm.org/docs/getting-started/)

>GraalVM install:
1. tar -xzf graalvm-jdk-21_macos-aarch64_bin
2. sudo mv graalvm-jdk-21+35.1 /Library/Java/JavaVirtualMachines
3. sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-jdk-21+35.1
>Step 3 fixes this error: ***graalvm-jdk-21+35.1 is damaged and can't be opened.***

> Docker install:
1. [Docker](https://docs.docker.com/get-docker/)

Run
---
1. sbt clean run

Curl
----
1. curl -v http://localhost:7979/now
2. curl -X POST http://localhost:7979/command -H "Content-Type: application/json" -d '{"name":"run command"}'

Metrics
-------
1. curl -s -H 'Accept: text/plain' -X GET http://localhost:7979/observe/metrics
>**Warning:** ```Server``` throws this *warning*:
```
Unexpected discovery of unknown previously-created meter; creating wrapper for io.micrometer.core.instrument.composite.CompositeFunctionCounter
```
>Yet the above curl command works correctly.

OpenAPI
--------
1. curl -X GET http://localhost:7979/openapi

Package GraalVM
---------------
>Takes around 60 seconds. **Note:** Only 1 main class is allowed in an sbt-native-packager project.
1. sbt 'show graalvm-native-image:packageBin'

Execute GraalVM
---------------
1. ./target/graalvm-native-image/helidon
2. curl -v http://localhost:7979/now

Docker
------
1. sbt clean compile stage
2. sbt docker:stage  ( see target/docker/stage/Dockerfile )
3. sbt docker:publishLocal
4. docker images  ( note helidon-server:0.4 listed )
5. docker run --rm -it -d -p 7979:7979/tcp helidon-server:0.4
6. docker ps  ( note helidon-server:0.4 listed )
7. docker exec -it container-id /bin/bash
   * curl http://localhost:7979/now  ( via docker container )
8. curl http://localhost:7979/now ( via localhost )
9. docker stop container-id  ( obtain container-id via docker ps listing )
10. docker ps  ( note helidon-server:0.4 not listed )

Docker Commands
---------------
* list images - docker images
* remove image - docker image rm image-id --force
* list containers - docker ps
* logs - docker logs container-id

Docker Publish
--------------
>To publish / push a docker image to DockerHub, consider one of these options:
* Docker Dashboard
* Microsoft VSCode Docker
* sbt -Ddocker.username=user-name -Ddocker.registry=registry-url docker:publish

Reference
---------
* [Helidon SE](https://helidon.io/docs/v4/#/se/introduction)
* [GraalVM](https://www.graalvm.org/docs/introduction/)
* [Dockerize Akka Http Server](https://www.freecodecamp.org/news/how-to-dockerise-a-scala-and-akka-http-application-the-easy-way-23310fc880fa/)
* [Dockker Akka Http and Postgres](https://faun.pub/docker-wonderland-akka-http-server-and-postgres-db-962b971ff28a)
* [Sbt Packager](https://www.scala-sbt.org/sbt-native-packager/formats/graalvm-native-image.html)
