

object testVector {
  def main(args: Array[String]): Unit = {
    val vd : Vector = Vectors.dense(1,0,6)
    println(vd(2))
    val vs: Vector = Vectors.sparse(6, Array(0,1,3,5), Array(9,5,2,7))
    println(vs(5))
  }
}
