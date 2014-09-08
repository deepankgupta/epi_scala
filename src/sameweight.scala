/**
 * Author: Deepank Gupta
 * Implement code to find the closest integer with the same weight.
 */

import scala.io.Source

/*
 * Insight: Find the least bit. If the least bit is not the last one then swap the first zero with the one next to it.
 */
def sameweight(word: Int) = {
  var y = word & ~(word - 1)
  if (y == 1) {
    y = (word + 1) & ~(word)
  }
  val z = y >> 1
  (word ^ y) ^ z
}

/*
 * This is the answer given in the book.
 */
def sameweightBook(x: Int): Int = {
  for (i <- 0 to 62) {
    val a: Int = (x >> i) & 1
    val b: Int = (x >> (i + 1)) & 1
    if ((a ^ b) > 0) {
      return (x ^ (1 << i)) | (1 << (i + 1))
    }
  }
  0
}

if (args.length > 0) {
  val words = Source.fromFile(args(0)).getLines().toList.map(line => line.toInt)

  words.foreach(word => {
    val ans = sameweight(word)
    Console.println("Original : " + word + " (" + word.toBinaryString + ")")
    Console.println("Closest integer: " + ans + " (" + ans.toBinaryString + ")")
  })
} else
  Console.err.println("Please enter filename.")