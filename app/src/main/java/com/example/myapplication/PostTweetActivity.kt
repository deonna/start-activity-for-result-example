package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PostTweetActivity : AppCompatActivity() {

    companion object {
        const val KEY_NEW_TWEET = "new tweet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_tweet)

        val postTweetInput = findViewById<EditText>(R.id.post_tweet_input)
        val doneButton = findViewById<Button>(R.id.post_tweet_done_button)

        doneButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(KEY_NEW_TWEET, postTweetInput.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}