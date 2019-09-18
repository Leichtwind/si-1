import java.math.BigInteger

object MathHelper {

  fun inverse(a: BigInteger, n: BigInteger): BigInteger {
    // first is the original value, second is the new
    var t = BigInteger.ZERO to BigInteger.ONE
    var r = n to a

    while (r.second != BigInteger.ZERO) {
      val quotient = r.first / r.second

      t = t.second to t.first - quotient * t.second
      r = r.second to r.first - quotient * r.second
    }

    if (r.first > BigInteger.ONE) {
      throw Exception("a is not invertible")
    }

    return if (t.first < BigInteger.ZERO) {
      t.first + n
    } else {
      t.first
    }
  }
}
