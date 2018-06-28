

object testLabeledPoint2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("testLabeledPoint2")
    val sc = new SparkContext(conf)
    val mu = MLUtils.loadLibSVMFile(sc,"file:///media/harold/SpareDisk/Java/SParkMLibDemo/labeleddata.txt")
    mu.foreach(println)
  }
}
