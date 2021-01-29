lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "tangerine.nsuthison",
      scalaVersion := "2.13.4",
    )),
    name := "dojo-scala"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test

scalacOptions ++= Seq("-deprecation", "-feature")

scalafmtOnCompile := true