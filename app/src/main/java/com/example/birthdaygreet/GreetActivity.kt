package com.example.birthdaygreet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class GreetActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME: String = "person_name"
    }

    private lateinit var rootLayout: ConstraintLayout
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greet)

        rootLayout = findViewById(R.id.root_layout)
        name = intent.getStringExtra(EXTRA_NAME)

        val greetingsTV: TextView = findViewById(R.id.greetTv)
        greetingsTV.text = getString(R.string.happy_birthday_greet, name)

        findViewById<Button>(R.id.shareBtn).setOnClickListener { shareBirthdayCard() }
    }

    private fun shareBirthdayCard() {
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_TEXT, getString(R.string.happy_birthday_greet, name))
        startActivity(Intent.createChooser(i, "Share birthday card via..."))
    }

}