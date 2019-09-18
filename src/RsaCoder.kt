import java.math.BigInteger
import java.util.*

object RsaCoder {

  private const val bitLength = 1024

  private val random = Random()

  private val p = BigInteger.probablePrime(bitLength, random)
  private val q = BigInteger.probablePrime(bitLength, random)

  private val module = p * q
  private val eulerFunctionValue = (p - BigInteger.ONE) * (q - BigInteger.ONE)

  private val publicExponent = BigInteger.valueOf(65537)
  private val secretExponent = computeSecretExponent()

  private fun computeSecretExponent(): BigInteger {
    var m = BigInteger.ONE

    while ((m * eulerFunctionValue + BigInteger.ONE) % publicExponent != BigInteger.ZERO) m++

    return (m * eulerFunctionValue + BigInteger.ONE) / publicExponent
  }

  fun encode(rawString: String): BigInteger {
    val bytes = rawString.toByteArray()

    return BigInteger(bytes).modPow(publicExponent, module)
  }

  fun decode(encoded: BigInteger): BigInteger {
    return encoded.modPow(secretExponent, module)
  }
}
