package com.example.emi_calc_android
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val principalEditText = findViewById<EditText>(R.id.editTextPrincipal)
        val rateEditText = findViewById<EditText>(R.id.editTextRate)
        val tenureEditText = findViewById<EditText>(R.id.editTextTenure)
        val calculateButton = findViewById<Button>(R.id.buttonCalculate)
        val resultTextView = findViewById<TextView>(R.id.textViewResult)

        calculateButton.setOnClickListener {
            val principal = principalEditText.text.toString().toDoubleOrNull()
            val annualRate = rateEditText.text.toString().toDoubleOrNull()
            val tenureYears = tenureEditText.text.toString().toDoubleOrNull()

            if (principal != null && annualRate != null && tenureYears != null) {
                val monthlyRate = annualRate / 12 / 100
                val numberOfMonths = tenureYears * 12

                val emi = (principal * monthlyRate * (1 + monthlyRate).pow(numberOfMonths)) / ((1 + monthlyRate).pow(numberOfMonths) - 1)
                resultTextView.text = "EMI: %.2f".format(emi)
            } else {
                resultTextView.text = "Please enter valid values"
            }
        }
    }
}
