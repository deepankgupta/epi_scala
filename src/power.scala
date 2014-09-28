/**
 * Author: Deepank Gupta
 * Problem: Compute x ^ y.
 */

import scala.io.Source

def power(a: Double,  b: Int): Double = {
  if (b == 0) return 1.0
  if (b == 1) return a
  var x = a
  var y = b
  if (b < 0) {
    x = 1 / x
    y = -y
  }
  val t = power(x, y >> 1)
  if ((y  & 1) == 1) {
    t * t * x
  } else {
    t * t
  }
}

if (args.length > 0) {
  val inputs = Source.fromFile(args(0)).getLines().toList.map(line => line.split(','))

  inputs.foreach(input => {
    val input_words = (input.map(word => word.toInt))
    if (input_words.length == 2) {
      val a = input_words(0)
      val b = input_words(1)
      Console.println(a + " * " + b + " = " + power(a, b))
    } else
      Console.println("Invalid input: ")
  })
} else
  Console.err.println("Please enter filename.")
