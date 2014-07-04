organization := "com.dataintelli"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= {
  val akkaVersion = "2.3.2"
  val sprayVersion = "1.3.1"
  Seq(
    "io.spray"          %  "spray-can"     % sprayVersion,
    "io.spray"          %  "spray-routing" % sprayVersion,
    "io.spray"          %  "spray-testkit" % sprayVersion % test,
    "com.typesafe.akka" %% "akka-actor"    % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit"  % akkaVersion  % test,
    "org.specs2"        %% "specs2-core"   % "2.3.7"      % test,
  )
}

Revolver.settings