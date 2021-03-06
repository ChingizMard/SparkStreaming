name := "Streaming"

version := "0.1"

scalaVersion := "2.11.2"


libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.2.0",
  "org.apache.spark" % "spark-sql_2.11" % "2.2.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.2.0",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0"
)