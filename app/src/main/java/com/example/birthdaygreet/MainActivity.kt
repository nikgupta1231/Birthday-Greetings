package com.example.birthdaygreet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_et)
        findViewById<Button>(R.id.submit_btn).setOnClickListener {
            val name: String = nameEditText.text.toString()
            when {
                name.isBlank() -> Toast.makeText(this, "Please enter valid name!", Toast.LENGTH_LONG).show()
                else -> handleButtonClick(name)
            }
        }
    }

    private fun handleButtonClick(name: String) {
        val intent = Intent(this, GreetActivity::class.java)
        intent.putExtra(GreetActivity.EXTRA_NAME, name)
        startActivity(intent)
    }

}