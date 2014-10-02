/**
 * Author: Deepank Gupta
 * Problem: Takes an integer K and returns the integer corresponding to digits of K written in reverse order.
 */

def reverseRecursive(k: Int, prev: Int): Int = {
  require(k >= 0)
  if (k / 10 == 0) {
    prev * 10 + k
  } else {
    reverseRecursive(k / 10, (prev * 10) + (k % 10))
  }
}


def reverse(k: Int): Int = {
  val ans = reverseRecursive(Math.abs(k), 0)
  if (k < 0) -ans else ans
}

val inputs = List(123, -123, 99, -99, 0, 1000, 1441)

inputs.foreach(input => {
  Console.println(input + " after reversing becomes : " + reverse(input))
})

