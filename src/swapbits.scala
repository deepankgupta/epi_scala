/**
 * Author: Deepank Gupta
 * Implement code that takes input a 64 bit integer and swaps the bits at indices i and j.
 */

import scala.io.Source

/*
 * Insight: If i and j bits are different, then only swap them.
 */
def swapbits(word: Int, i: Int, j: Int) = {
  if (((word >> i) & 1) != ((word >> j) & 1))
    ((word ^ (1 << i)) ^ (1 << j))
  else
    word
}

if (args.length > 0) {
  val inputs = Source.fromFile(args(0)).getLines().toList.map(line => line.split(','))

  inputs.foreach(input => {
    val input_words = (input.map(word => word.toInt))
    if (input_words.length == 3) {
      val num = input_words(0)
      val i = input_words(1)
      val j = input_words(2)
      if (i < 0 || i >= 64 || j < 0 || j >= 64)
        Console.println("Invalid input: " + input)
      else
        Console.println("Original : " + num.toBinaryString +
          ". Swapping bit " + i + " and " + j + " gives " + swapbits(num, i, j).toBinaryString)
    } else
      Console.println("Invalid input: " + input)
  })
} else
  Console.err.println("Please enter filename.")