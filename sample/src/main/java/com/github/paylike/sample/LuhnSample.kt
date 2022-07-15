package com.github.paylike.sample

import com.github.paylike.kotlin_luhn.PaylikeLuhn

fun main() {
    val valid = "6123451234567893"
    val invalid = "76009244561"

    val validResult = PaylikeLuhn.isValid(valid)
    println(validResult) // true
    val invalidResult = PaylikeLuhn.isValid(invalid)
    println(invalidResult) // false
    val incompleteResult = PaylikeLuhn.calculateCheckDigit(valid)
    println(incompleteResult) // "3"
}
