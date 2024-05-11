package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var incButton: Button
    lateinit var decButton: Button
    lateinit var textView: TextView
    private var uiState: UiState = UiState.Base("0")
    private var count: Count = Count.Base(2, 4, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.countTextView)
        incButton = findViewById(R.id.incrementButton)
        decButton = findViewById(R.id.decrementButton)

        if (savedInstanceState == null) {
            uiState = count.initial(textView.text.toString())
            uiState.apply(textView, incButton, decButton)
        }

        incButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, incButton, decButton)
        }

        decButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(textView, incButton, decButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY, UiState::class.java)!!
        uiState.apply(textView, incButton, decButton)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}