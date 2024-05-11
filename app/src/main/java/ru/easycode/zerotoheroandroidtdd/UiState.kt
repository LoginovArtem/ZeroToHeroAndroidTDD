package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, incButton: Button, decButton: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, incButton: Button, decButton: Button) {
            textView.text = text
            incButton.isEnabled = true
            decButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, incButton: Button, decButton: Button) {
            textView.text = text
            incButton.isEnabled = false
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, incButton: Button, decButton: Button) {
            textView.text = text
            decButton.isEnabled = false
        }
    }
}