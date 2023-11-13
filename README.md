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
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.runNowClient
 [2] objektwerks.runNowServer

Enter number:
```

Curl
----
1. curl -v http://localhost:7979/now

Package
-------
1. sbt 'show graalvm-native-image:packageBin'

Reference
---------
* [Helidon SE](https://helidon.io/docs/v4/#/se/introduction)