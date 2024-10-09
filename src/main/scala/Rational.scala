// src/main/scala/serie1/Rational.scala

package serie1  // Ajout de la déclaration de package

class Rational(numerator: Int, denominator: Int) extends Ordered[Rational] {
  require(denominator != 0, "Le dénominateur ne peut pas être 0.")

  private val gcdVal: Int = gcd(numerator, denominator)
  val num: Int = numerator / gcdVal
  val denom: Int = denominator / gcdVal

  def this(numerator: Int) = this(numerator, 1)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def unary_- : Rational = new Rational(-num, denom)

  def inverse: Rational = new Rational(denom, num)

  def +(that: Rational): Rational = new Rational(
    this.num * that.denom + that.num * this.denom,
    this.denom * that.denom
  )

  def -(that: Rational): Rational = new Rational(
    this.num * that.denom - that.num * this.denom,
    this.denom * that.denom
  )

  def *(that: Rational): Rational = new Rational(
    this.num * that.num,
    this.denom * that.denom
  )

  def /(that: Rational): Rational = new Rational(
    this.num * that.denom,
    this.denom * that.num
  )

  override def compare(that: Rational): Int = {
    (this.num * that.denom) - (that.num * this.denom)
  }

  override def equals(that: Any): Boolean = that match {
    case that: Rational => this.num == that.num && this.denom == that.denom
    case _ => false
  }

  override def hashCode(): Int = (num, denom).##

  override def toString: String = denom match {
    case 1 => s"$num"
    case _ => s"$num/$denom"
  }
}
