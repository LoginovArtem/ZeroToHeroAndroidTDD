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
    lateinit var button: Button
    private var clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rl = findViewById<LinearLayout>(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById<Button>(R.id.removeButton)


        if (savedInstanceState != null ) {
            val isDeleted = savedInstanceState.getBoolean("visibilityGone")
            val isClicked = savedInstanceState.getBoolean("clickable")
            if (isDeleted) {
                rl.removeView(textView)
                button.isEnabled = !isClicked
            }
        }

        button.setOnClickListener {
            rl.removeView(textView)
            button.isEnabled = false
            clicked = true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("visibilityGone", clicked)
        outState.putBoolean("clickable", clicked)
    }

}