// src/main/scala/serie1/Main.scala

package serie1

@main def runRational(): Unit = {
  val r1 = new Rational(1, 2)
  val r2 = new Rational(3)

  println(s"r1 = $r1")
  println(s"r2 = $r2")

  val somme = r1 + r2
  println(s"Somme de r1 et r2 = $somme")

  val inverseR1 = r1.inverse
  println(s"Inverse de r1 = $inverseR1")
}
