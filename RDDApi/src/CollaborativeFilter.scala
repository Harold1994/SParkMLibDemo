

object CollaborativeFilter {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CollaborativeFilter").setMaster("local")
    val sc = new SparkContext(conf)
    val data = sc.textFile("u1.txt")
    val rating = data.map(_.split(" ") match {
      case Array(user, item, rate) =>
        Rating(user.toInt, item.toInt, rate.toDouble)
    })
    val rank = 2//设置隐藏因子
    val numIteration = 2 //设置迭代次数
    val model = ALS.train(rating,rank,numIteration,0.01)
    val rs = model.recommendProducts(2,1)//为用户２推荐一个商品
    rs.foreach(println)
  }
}
