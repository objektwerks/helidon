Helidon
-------
>Helidon feature tests using Scala 3.

Install
-------
>See: https://www.graalvm.org/docs/getting-started/

>Example install on MacOs-M1:
1. tar -xzf graalvm-jdk-21_macos-aarch64_bin
2. sudo mv graalvm-jdk-21+35.1 /Library/Java/JavaVirtualMachines
3. sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-jdk-21+35.1
>Step 3 will fix this error: ***graalvm-jdk-21+35.1 is damanged and can't be opened.***

Run
---
1. sbt clean compile run

Curl
----
1. curl -v http://localhost:7979/now

Package GraalVM
---------------
>Takes around 60 seconds. **Note:** Only 1 main class is allowed in an sbt-native-packager project.
1. sbt 'show graalvm-native-image:packageBin'

Execute GraalVM
---------------
1. ./target/graalvm-native-image/helidon
2. curl -v http://localhost:7979/now


Reference
---------
* [Helidon SE](https://helidon.io/docs/v4/#/se/introduction)
* [GraalVM](https://www.graalvm.org/docs/introduction/)
* [Dockerize Akka Http Server](https://www.freecodecamp.org/news/how-to-dockerise-a-scala-and-akka-http-application-the-easy-way-23310fc880fa/)
* [Dockker Akka Http and Postgres](https://faun.pub/docker-wonderland-akka-http-server-and-postgres-db-962b971ff28a)
* [Sbt Packager](https://www.scala-sbt.org/sbt-native-packager/formats/graalvm-native-image.html)