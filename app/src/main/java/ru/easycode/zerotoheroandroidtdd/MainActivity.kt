package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rl = findViewById<LinearLayout>(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val button = findViewById<Button>(R.id.removeButton)

        if (savedInstanceState != null ) {
            val isDeleted = savedInstanceState.getBoolean("visibilityGone")
            val isClickable = savedInstanceState.getBoolean("clickable")
            if (isDeleted) {
                rl.removeView(textView)
                button.isEnabled = isClickable
            }
        }

        button.setOnClickListener {
            rl.removeView(textView)
            button.isEnabled = false
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("visibilityGone", true)
        outState.putBoolean("clickable", false)
    }

}