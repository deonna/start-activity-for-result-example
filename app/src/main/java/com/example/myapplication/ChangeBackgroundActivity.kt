package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ChangeBackgroundActivity : AppCompatActivity() {

    companion object {
        const val KEY_NEW_COLOR = "new color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_background)

        val purpleButton = findViewById<Button>(R.id.purple_button)
        val tealButton = findViewById<Button>(R.id.teal_button)

        purpleButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(KEY_NEW_COLOR, ContextCompat.getColor(this, R.color.purple_200))
            setResult(RESULT_OK, intent)
            finish()
        }

        tealButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(KEY_NEW_COLOR, ContextCompat.getColor(this, R.color.teal_700))
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}