package hu.riltech.kotlin_luhn

object PaylikeLuhn {

    fun isValid(cardNumber: String): Boolean {
        return cardNumber.substring(cardNumber.length - 1) ==
                _calculate(cardNumber.substring(0, cardNumber.length - 1))
    }
    fun calculateCheckDigit(cardNumber: String): String
    {
        return _calculate(cardNumber.substring(0, cardNumber.length - 1))
    }
//    private fun _sum(a: String, b: String) : String //
//    {
//        return "${a.toInt() + b.toInt()}"
//    }
    private fun _sumDigits(number: String): Int
    {
        return number.split("")
            .filter { it.length > 0 }
            .reduce { acc, curr -> "${acc.toInt() + curr.toInt()}" }.toInt()
    }
    private fun _calculate(numbers: String): String
    {
        val length = numbers.length
        val map: Map<Int, String> =
            numbers
            .split("")
            .filter { it.length > 0 }
            .mapIndexed { index: Int, s: String -> index to s }
            .toMap()
        val product: Int =
            map
            .entries
            .fold(0) { acc, element ->
                    val temp: Int = when ((element.key + length) % 2 == 1) {
                        true -> _sumDigits("${element.value.toInt() * 2}")
                        false -> element.value.toInt()
                    }
                    return@fold acc + temp
                }
        return "${((10 - (product % 10)) % 10)}"
    }
}
