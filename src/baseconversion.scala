/**
 * Author: Deepank Gupta
 * Problem: Compute x ^ y.
 */

import scala.io.Source

def convertBase(num: String, b1: Int, b2: Int): String = {
  val digitsMap = Map(
    '0' -> 0,
    '1' -> 1,
    '2' -> 2,
    '3' -> 3,
    '4' -> 4,
    '5' -> 5,
    '6' -> 6,
    '7' -> 7,
    '8' -> 8,
    '9' -> 9,
    'A' -> 10,
    'B' -> 11,
    'C' -> 12,
    'D' -> 13,
    'E' -> 14,
    'F' -> 15
  )
  val numberToDigitsMap = digitsMap.map(_.swap)
  var iter = num.length() - 1
  def add(num: Double, digit: Char) = {
    val result = num + (digitsMap(digit) * Math.pow(b1, iter))
    iter -= 1
    result
  }
  var value = num.toList.foldLeft(0.0)(add).toInt
  var result = ""
  while (value > 0) {
    result = numberToDigitsMap(value % b2) + result
    value /= b2
  }
  result
}

if (args.length > 0) {
  val inputs = Source.fromFile(args(0)).getLines().toList.map(line => line.split(','))

  inputs.foreach(input => {
    val num = input(0)
    val input_words = (input.drop(1).map(word => word.toInt))
    if (input_words.length == 2) {
      val b1 = input_words(0)
      val b2 = input_words(1)
      Console.println(num + " in base " + b1 + " becomes " + convertBase(num, b1, b2) + " in base: " + b2)
    } else
      Console.println("Invalid input: ")
  })
} else
  Console.err.println("Please enter filename.")


