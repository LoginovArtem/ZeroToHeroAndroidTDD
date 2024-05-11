package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import com.squareup.wire.internal.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, button: Button){

    }

    data class Base (private val text : String) : UiState {

    }
    data class Max (private val text : String) : UiState {

    }
    data class Min (private val text : String) : UiState {

    }
}