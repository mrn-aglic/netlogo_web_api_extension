enablePlugins(org.nlogo.build.NetLogoExtension)

netLogoExtName      := "sample-scala"

netLogoClassManager := "test.SampleScalaExtension"

netLogoZipSources   := false

scalaVersion           := "2.11.7"

scalaSource in Compile := baseDirectory.value / "src"

scalacOptions          ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-encoding", "us-ascii")

val liftVersion = "2.6.2"

libraryDependencies ++= Seq(
    "org.eclipse.jetty" % "jetty-webapp" % "9.3.8.v20160314",
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default"
)

// The remainder of this file is for options specific to bundled netlogo extensions
// if copying this extension to build your own, you need nothing past line 14 to build
// sample-scala.zip
netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

netLogoVersion := "6.0.0-M5"
