package com.example.summerpractice22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_calc)
        val textView: TextView = findViewById(R.id.textViewAnswer)
        //val image : Image = findViewById(R.id.mainImage)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextNumberHeight: EditText = findViewById(R.id.editTextNumberHeight)
        val editTextNumberWeight: EditText = findViewById(R.id.editTextNumberWeight)
        val editTextNumberAge: EditText = findViewById(R.id.editTextNumberAge)


        button.setOnClickListener {
            if (editTextNumberAge.text.isEmpty() || editTextName.text.isEmpty() ||
                editTextNumberHeight.text.isEmpty() ||editTextNumberWeight.text.isEmpty()){
                textView.text = "Fields are empty"
                return@setOnClickListener
            }

            val name: String = editTextName.text.toString()
            val height: Int = (editTextNumberHeight.text.toString()).toInt()
            val weight: Float = editTextNumberWeight.text.toString().toFloat()
            val age: Int = (editTextNumberAge.text.toString()).toInt()

            //Как сделать красивее не придумал
            if ((name.length > 50) || (height !in 0..250)
                || (weight <= 0 || weight >= 250) || (age !in 0..150)
            ) {
                textView.text = "Invalid values :с"
            } else {
                val result: Int =
                    (88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age) + name.length).roundToInt()
                textView.text = "Answer:  $result"

                //coolFormula = 88,36 + (13,4 × вес в кг) + (4,8 × рост в см) – (5,7 × возраст в годах) + длина имени.
            }

        }
    }
}