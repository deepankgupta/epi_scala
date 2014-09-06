/**
 * Author: Deepank Gupta
 * Problem: How would you compute parity of a very large number of 64-bit words.
 */

import scala.io.Source

/*
 * Computes parity of a single word. This uses the trick that x & ~(x - 1) will return back last 1.
 * So complexity O(b) where b is number of bits set to 1.
 */
def computeParity(word: Int) = {
  var bits = 0
  var x = word
  while (x != 0) {
    val y = x & ~(x - 1)
    x = x ^ y
    bits = bits + 1
  }
  bits % 2
}

/*
 * Precompute for faster parity calculation.
 */
def preComputeParity(size: Int) = {
  ((0 to size - 1).map(computeParity)).toArray
}

/*
 * Uses the fact that you have a precomputed set of parity results with upto num_bits precomputed.
 * TODO: Add checks to guarantee that num_bits is a power of 2.
 */
def fasterParity(word: Int, parity_results: Array[Int], num_bits: Int) = {
  var x = word
  var bits = 0
  for (i <- 0 to (64/num_bits - 1)) {
    val y = x & (parity_results.length - 1)
    bits = bits + parity_results(y)
    x = x >> num_bits
  }
  bits % 2
}

if (args.length > 0) {
  val words = Source.fromFile(args(0)).getLines().toList.map(line => line.toInt)
  val SIZE = 256 * 256
  val NUM_BITS = 16
  val parity_results = preComputeParity(SIZE)

  words.foreach(word => {
    Console.println("Parity for word: " + word.toBinaryString +
      " is : " + fasterParity(word, parity_results, NUM_BITS))
  })
} else {
  Console.err.println("Please enter filename.")
}