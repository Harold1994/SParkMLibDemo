

object testIndexedRowMatrix {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("testIndexedRowMatrix")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("labeleddata.txt")
      .map(_.split(" ")
        .map(_.toDouble))
      .map(line => Vectors.dense(line))
      .map((vd) => new IndexedRow(vd.size,vd))
    val irm = new IndexedRowMatrix(rdd)
    println(irm.getClass)
    irm.rows.foreach(println)
  }
}
