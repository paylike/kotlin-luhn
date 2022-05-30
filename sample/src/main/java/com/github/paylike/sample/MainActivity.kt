package com.github.paylike.sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.paylike.kotlin_luhn.PaylikeLuhn

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var valid = "6123451234567893"
        var invalid = "76009244561"
        var validResult = PaylikeLuhn.isValid(valid) // true
        var invalidResult = PaylikeLuhn.isValid(invalid) // false
        var incompleteResult = PaylikeLuhn.calculateCheckDigit(valid) // "3"

        findViewById<TextView>(R.id.valid).setText(valid)
        findViewById<TextView>(R.id.invalid).setText(invalid)
        findViewById<TextView>(R.id.valid).setText(valid)
        findViewById<TextView>(R.id.validResult).setText(validResult.toString())
        findViewById<TextView>(R.id.invalidResult).setText(invalidResult.toString())
        findViewById<TextView>(R.id.incompleteResult).setText(incompleteResult)
    }
}
