package com.github.paylike.kotlin_luhn

import org.junit.Assert.*
import org.junit.Test

class PaylikeLuhnTest {
    @Test
    fun paylikeLuhnTest() {
        val validNumbers: List<String> =
            listOf(
                /** From the ISO standard */
                "6123451234567893",

                /**
                 * http://www.paypalobjects.com/en_US/vhelp/paypalmanager_help/credit_card_numbers.htm
                 */
                "4012111111111111",
                "378282246310005",
                "371449635398431",
                "378734493671000",
                "5610591081018250",
                "30569309025904",
                "38520000023237",
                "6011111111111117",
                "6011000990139424",
                "3530111333300000",
                "3566002020360505",
                "5555555555554444",
                "5105105105105100",
                "4111111111111111",
                "4012888888881881",
                "4222222222222",
                "5019717010103742",
                "6331101999990016"
            )
        val invalidNumbers: List<String> = listOf("76009244561", "4571736004738485")
        validNumbers.forEach {
            assertTrue(PaylikeLuhn.isValid(it))
            assertEquals(it.last().toString(), PaylikeLuhn.calculateCheckDigit(it))
        }
        invalidNumbers.forEach { assertFalse(PaylikeLuhn.isValid(it)) }
    }
}
