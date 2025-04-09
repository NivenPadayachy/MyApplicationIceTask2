package com.example.myapplicationicetask2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupSizes: RadioGroup
    private lateinit var radioSmall: RadioButton
    private lateinit var radioMedium: RadioButton
    private lateinit var radioLarge: RadioButton
    private lateinit var checkExtraCheese: CheckBox
    private lateinit var checkOlives: CheckBox
    private lateinit var buttonCompute: Button
    private lateinit var buttonClear: Button
    private lateinit var textViewTotal: TextView

    private val smallPizzaPrice = 55.99
    private val mediumPizzaPrice = 89.99
    private val largePizzaPrice = 119.99
    private val extraCheesePrice = 5.50
    private val olivesPrice = 3.50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        radioGroupSizes = findViewById(R.id.radioGroupSizes)
        radioSmall = findViewById(R.id.radioSmall)
        radioMedium = findViewById(R.id.radioMedium)
        radioLarge = findViewById(R.id.radioLarge)
        checkExtraCheese = findViewById(R.id.checkExtraCheese)
        checkOlives = findViewById(R.id.checkOlives)
        buttonCompute = findViewById(R.id.buttonCompute)
        buttonClear = findViewById(R.id.buttonClear)
        textViewTotal = findViewById(R.id.textViewTotal)


        buttonCompute.setOnClickListener { computeTotal() }
        buttonClear.setOnClickListener { clearSelections() }
    }

    private fun computeTotal() {
        var total = 0.0


        when (radioGroupSizes.checkedRadioButtonId) {
            R.id.radioSmall -> total += smallPizzaPrice
            R.id.radioMedium -> total += mediumPizzaPrice
            R.id.radioLarge -> total += largePizzaPrice
        }


        if (checkExtraCheese.isChecked) {
            total += extraCheesePrice
        }
        if (checkOlives.isChecked) {
            total += olivesPrice
        }


        textViewTotal.text = "Total: R${"%.2f".format(total)}"
    }

    private fun clearSelections() {

        radioGroupSizes.clearCheck()

       
        checkExtraCheese.isChecked = false
        checkOlives.isChecked = false


        textViewTotal.text = "Total: R0.00"
    }
}