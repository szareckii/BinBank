package com.zareckii.binbank.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.zareckii.binbank.App
import com.zareckii.binbank.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as App).viewModel

        val input = findViewById<TextInputEditText>(R.id.inputEditText)
        val searchButton = findViewById<Button>(R.id.fetchButton)
        val progress = findViewById<View>(R.id.progressLayout)
        val text = findViewById<TextView>(R.id.textView)

        searchButton.setOnClickListener {
            viewModel.fetch(input.text.toString())
        }
        viewModel.liveData.observe(this) {
            it.show(progress, text, searchButton)
        }
    }
}