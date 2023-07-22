package com.example.assignment1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinnerVal: Spinner = findViewById(R.id.MySpinner)
        var options = arrayOf("EURO TO JD", "JD TO EURO")
        var flag: String = "EURO TO JD"
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2);
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val button: Button = findViewById(R.id.Convert)
        val quantity: EditText = findViewById(R.id.Text1)
        val result: TextView = findViewById(R.id.Result)
        var resultLabel : TextView = findViewById(R.id.ResultLabel)
        button.setOnClickListener { view ->
            var test: String = quantity.text.toString()
            if (test.toIntOrNull() == null) {
                result.isVisible = false
                resultLabel.text = "Input is not numeric"
                resultLabel.isVisible = true
            }
            else {
                resultLabel.text = "Result:"
                var x: Int = quantity.text.toString().toInt()
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                if (flag == "EURO TO JD")
                    result.text = df.format(x * 0.7891).toString() + " JD";
                else
                    result.text = df.format(x * 1.2671).toString() + " EURO";
                result.isVisible = true;
                resultLabel.isVisible = true;
                result.setBackgroundColor(Color.parseColor("#FFD4C6"))
            }
        }
    }
}