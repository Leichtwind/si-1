fun main() {
  val message = readLine() ?: ""

  val encoded = RsaCoder.encode(message)
  val decoded = RsaCoder.decode(encoded)

  println("Raw: $message")
  println("Encoded: $encoded")
  println("Decoded: $decoded")
  println("Decoded string: ${decoded.toByteArray().toString(Charsets.UTF_8)}")
}
