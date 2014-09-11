/**
 * Author: Deepank Gupta
 * Implement code to compute multiplication of two numbers.
 */

import scala.io.Source

def add(a: Int, b: Int) = {
  var tempa = a
  var tempb = b
  var carryIn = 0
  var k = 1
  var sum = 0
  while (tempa > 0 || tempb > 0) {
    val ak = a & k
    val bk = b & k
    sum = sum | (ak ^ bk ^ carryIn)
    val carryOut = (ak & bk) | (ak & carryIn) | (bk & carryIn)
    carryIn = carryOut << 1
    k = k << 1
    tempa = tempa >> 1
    tempb = tempb >> 1
  }
  sum | carryIn
}

def multiply(a: Int, b: Int) = {
  var x = a
  var y = b
  var sum = 0
  while (x > 0) {
    if ((x & 1) > 0) {
      sum = add(sum, y)
    }
    x = x >> 1
    y = y << 1
  }
  sum
}

if (args.length > 0) {
  val inputs = Source.fromFile(args(0)).getLines().toList.map(line => line.split(','))

  inputs.foreach(input => {
    val input_words = (input.map(word => word.toInt))
    if (input_words.length == 2) {
      val a = input_words(0)
      val b = input_words(1)
      if (a < 0 || b < 0) {
        Console.println("Invalid input")
      } else {
        Console.println(a + " * " + b + " = " + multiply(a, b))
      }
    } else
      Console.println("Invalid input: ")
  })
} else
  Console.err.println("Please enter filename.")
