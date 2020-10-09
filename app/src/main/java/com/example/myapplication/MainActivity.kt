package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.ChangeBackgroundActivity.Companion.KEY_NEW_COLOR
import com.example.myapplication.PostTweetActivity.Companion.KEY_NEW_TWEET

class MainActivity : AppCompatActivity() {

    companion object {
        private const val POST_TWEET_ACTIVITY_REQUEST_CODE = Activity.RESULT_FIRST_USER + 1
        private const val CHANGE_BACKGROUND_REQUEST_CODE = POST_TWEET_ACTIVITY_REQUEST_CODE + 1
    }

    private lateinit var container: ConstraintLayout
    private lateinit var newTweetText: TextView
    private lateinit var postTweetButton: Button
    private lateinit var changeBackgroundButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container)
        newTweetText = findViewById(R.id.new_tweet_text)
        postTweetButton = findViewById(R.id.post_tweet_button)
        changeBackgroundButton = findViewById(R.id.change_background_button)

        postTweetButton.setOnClickListener {
            val intent = Intent(this, PostTweetActivity::class.java)
            startActivityForResult(intent, POST_TWEET_ACTIVITY_REQUEST_CODE)
        }

        changeBackgroundButton.setOnClickListener {
            val intent = Intent(this, ChangeBackgroundActivity::class.java)
            startActivityForResult(intent, CHANGE_BACKGROUND_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) {
            Log.e(MainActivity::class.java.simpleName, "Data is null.")
            return
        }

        when (requestCode) {
            POST_TWEET_ACTIVITY_REQUEST_CODE -> {
                // TODO: display the new tweet
                val newTweet = data.getStringExtra(KEY_NEW_TWEET)
                if (newTweet != null) {
                    newTweetText.text = newTweet
                }
//                newTweet?.let { newTweetText.text = it }
            }

            CHANGE_BACKGROUND_REQUEST_CODE -> {
                // TODO: change the background color to the color sent
                val newColor = data.getIntExtra(KEY_NEW_COLOR, Int.MAX_VALUE)
                if (newColor != Int.MAX_VALUE) {
                    container.setBackgroundColor(newColor)
                }
            }
        }
    }
}