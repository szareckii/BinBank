package com.zareckii.binbank.presentation

import android.view.View
import android.widget.Button
import android.widget.TextView

interface UiState {

    fun show(progress: View, textView: TextView, searchButton: Button)

    object Loading : UiState {
        override fun show(progress: View, textView: TextView, searchButton: Button) {
            progress.visibility = View.VISIBLE
            searchButton.isEnabled = false
        }
    }

    class Success(private val text: String) : UiState {
        override fun show(progress: View, textView: TextView, searchButton: Button) {
            progress.visibility = View.GONE
            textView.text = text
            searchButton.isEnabled = true
        }
    }

    class Error(private val text: String) : UiState {
        override fun show(progress: View, textView: TextView, searchButton: Button) {
            progress.visibility = View.GONE
            textView.text = text
            searchButton.isEnabled = true
        }
    }
}