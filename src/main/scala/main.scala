import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext, streaming}
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object HelloWorld {

  def main(args: Array[String]): Unit = {
    //Disable All INFO Statements
    Logger.getLogger("org").setLevel(Level.OFF)

    val conf = new SparkConf().setAppName("Basic Stream NetCat").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(10))
    val streamRDD = ssc.socketTextStream("127.0.0.1", 2222)
    val wc = streamRDD.flatMap(line => line.split(" "))
                      .map(word => (word, 1))
                      .reduceByKey(_+_)
    wc.print()

    ssc.start()
    ssc.awaitTermination()
  }

}