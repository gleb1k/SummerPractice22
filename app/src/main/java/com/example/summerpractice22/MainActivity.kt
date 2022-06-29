package com.example.summerpractice22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var textView: TextView? = null
    private var image: ImageView? = null
    private var editTextName: EditText? = null
    private var editTextNumberHeight: EditText? = null
    private var editTextNumberWeight: EditText? = null
    private var editTextNumberAge: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_calc)
        val textView: TextView = findViewById(R.id.textViewAnswer)
        val image: ImageView = findViewById(R.id.mainImage)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextNumberHeight: EditText = findViewById(R.id.editTextNumberHeight)
        val editTextNumberWeight: EditText = findViewById(R.id.editTextNumberWeight)
        val editTextNumberAge: EditText = findViewById(R.id.editTextNumberAge)

        //fun invalidValues() {
        //  textView.setText("Недопустимые значения, проверьте поля!")
        // }

        // пытался что-то закостылить с валидацией. попытка провалилась.
        // теперь просто крашит при неправильных значениях (не баг, а фича)

        button?.setOnClickListener {
            val name: String = editTextName?.getText().toString()
            val height: Int = Integer.parseInt(editTextNumberHeight?.getText().toString())
            val weight: Int = Integer.parseInt(editTextNumberWeight?.getText().toString())
            val age: Int = Integer.parseInt(editTextNumberAge?.getText().toString())

            if (name.length > 50) throw Exception("Превышена длина имени")
            if (height <= 0 || height >= 250) throw Exception("Превышен рост")
            if (weight <= 0 || weight >= 250) throw Exception("Превышен вес")
            if (age <= 0 || age >= 150) throw Exception("Превышен возраст")

            //BMR = 88,36 + (13,4 × вес в кг) + (4,8 × рост в см) – (5,7 × возраст в годах).

            val result : Long = Math.round(88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age))
            textView.setText("$name Your callories is:  $result")
            println(name)
            print(height)
        }

    }
}