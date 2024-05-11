package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.hideButton)
        textView = findViewById<TextView>(R.id.titleTextView)

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getInt("a")
            textView.visibility = isVisible
        }

        button.setOnClickListener {
            textView.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("a",textView.visibility)
    }

}