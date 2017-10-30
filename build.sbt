name := "scala-demo"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-api" % "1.6.4",
    "org.jboss.netty" % "netty" % "3.2.9.Final",
    "com.typesafe.play" %% "play" % "2.6.2",
    "com.typesafe.play" %% "play-cache" % "2.6.2",
    "com.typesafe.play" %% "play-json" % "2.6.2",
    "com.typesafe.akka" %% "akka-actor" % "2.4.19",
    "com.typesafe.akka" %% "akka-http" % "10.0.9",
    "com.typesafe.akka" %% "akka-slf4j" % "2.4.19",
    "com.typesafe.akka" %% "akka-stream" % "2.4.19",
    "com.typesafe.akka" %% "akka-testkit" % "2.4.19",
    "org.scalatestplus" %% "play" % "1.4.0"
)
