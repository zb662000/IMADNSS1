package com.example.a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //declare
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialise
        searchButton= findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView= findViewById(R.id.resultTextView)

        searchButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..50) {
                val employeeName = when (age) {
                    30 -> "Thato "

                    35 -> "Keval "
                    40 -> "Michael Jackson"
                    28 -> "Emily in Paris"
                    else -> null
                }

                val message = if (employeeName != null) "The employee's name is $employeeName."
                else "No employee found with the entered age."
                resultTextView.text = message

            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 50."
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}

