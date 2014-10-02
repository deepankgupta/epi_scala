import scala.io.Source

/**
 * Author: Deepank Gupta
 * Problem: Implement a function that converts Excel column ids to the corresponding integer with "A" corresponding to 1
 */

val digitsMap = Map(
  'A' -> 1,
  'B' -> 2,
  'C' -> 3,
  'D' -> 4,
  'E' -> 5,
  'F' -> 6,
  'G' -> 7,
  'H' -> 8,
  'I' -> 9,
  'J' -> 10,
  'K' -> 11,
  'L' -> 12,
  'M' -> 13,
  'N' -> 14,
  'O' -> 15,
  'P' -> 16,
  'Q' -> 17,
  'R' -> 18,
  'S' -> 19,
  'T' -> 20,
  'U' -> 21,
  'V' -> 22,
  'W' -> 23,
  'X' -> 24,
  'Y' -> 25,
  'Z' -> 26
)

def decode(id: String): Int = {
  var iter = id.length() - 1
  def add(num: Double, digit: Char) = {
    val result = num + (digitsMap(digit) * Math.pow(26, iter))
    iter -= 1
    result
  }
  id.toList.foldLeft(0.0)(add).toInt
}

if (args.length > 0) {
  val inputs = Source.fromFile(args(0)).getLines().toList

  inputs.foreach(input => {
    Console.println(input + " in excel corresponds to id:  " + decode(input))
  })
} else
  Console.err.println("Please enter filename.")

