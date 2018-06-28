

object testRowMatrix {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("testRowMatrix")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("labeleddata.txt")
      .map(_.split(" ")
      .map(_.toDouble))
      .map(line => Vectors.dense(line))
    val rm = new RowMatrix(rdd)
    println(rm.numRows())
    println(rm.numCols())
  }
}
