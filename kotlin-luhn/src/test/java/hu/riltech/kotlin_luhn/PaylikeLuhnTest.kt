package hu.riltech.kotlin_luhn

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PaylikeLuhnTest {
    @Test
    fun test() {
        val pans: List<String> = listOf(
            // from the ISO standard
            "6123451234567893",

            // http://www.paypalobjects.com/en_US/vhelp/paypalmanager_help/credit_card_numbers.htm
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
        val invalid: List<String> = listOf(
            "76009244561",
            "4571736004738485"
        )
        pans.forEach {
            val result = PaylikeLuhn.isValid(it)
            assertTrue(result)
            val calculatedChecksum = PaylikeLuhn.calculateCheckDigit(it)
            val givenChecksum = it.substring(it.length - 1)
            assertTrue(calculatedChecksum == givenChecksum)
        }
        invalid.forEach {
            assertTrue(!PaylikeLuhn.isValid(it))
        }
    }
}