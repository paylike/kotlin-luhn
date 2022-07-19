package com.github.paylike.kotlin_luhn

object PaylikeLuhn {
    /**
     * isValid decides if [cardNumber] is valid or not
     */
    fun isValid(cardNumber: String): Boolean {
        return cardNumber.substring(cardNumber.length - 1) ==
                calculate(cardNumber.substring(0, cardNumber.length - 1))
    }

    /**
     * calculateCheckDigit will return the check digit of [cardNumber]
     */
    fun calculateCheckDigit(cardNumber: String): String
    {
        return calculate(cardNumber.substring(0, cardNumber.length - 1))
    }

    private fun sumDigits(number: String): Int
    {
        return number.split("")
            .filter { it.isNotEmpty() }
            .fold ("0") { acc, curr -> "${acc.toInt() + curr.toInt()}" }.toInt()
    }

    private fun calculate(numbers: String): String
    {
        val length = numbers.length
        val map: Map<Int, String> =
            numbers
            .split("")
            .filter { it.isNotEmpty() }
            .mapIndexed { index: Int, s: String -> index to s }
            .toMap()
        val product: Int =
            map
            .entries
            .fold(0) { acc, element ->
                    val temp: Int = when ((element.key + length) % 2 == 1) {
                        true -> sumDigits("${element.value.toInt() * 2}")
                        false -> element.value.toInt()
                    }
                    return@fold acc + temp
                }
        return "${((10 - (product % 10)) % 10)}"
    }
}
