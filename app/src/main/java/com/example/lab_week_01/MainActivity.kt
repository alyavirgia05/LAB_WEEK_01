package com.example.lab_week_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.view.Gravity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val numberInput = findViewById<TextInputEditText>(R.id.number_input)?.text.toString().trim()

            if (nameInput.isEmpty()) {
                showToast(getString(R.string.name_empty))
            } else if (numberInput.length != 11) {
                showToast(getString(R.string.number_error))
            } else {
                nameDisplay?.text = getString(R.string.display_text, nameInput, numberInput)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }
}
