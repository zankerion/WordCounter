package com.example.wordcounter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var countTypeSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        countTypeSpinner = findViewById(R.id.countTypeSpinner)
        resultTextView = findViewById(R.id.resultTextView)

        val adapter = ArrayAdapter.createFromResource(this, R.array.count_types, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countTypeSpinner.adapter = adapter

        countTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                // Handle spinner item selection if needed
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Handle nothing selected if needed
            }
        }
    }

    fun calculateCount(view: View) {
        val text = editText.text.toString()
        val countType = countTypeSpinner.selectedItem.toString()
        var count = 0

        if (text.isEmpty()) {
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
            return
        }

        if (countType == getString(R.string.words)) {
            count = WordCounter.countWords(text)
        } else {
            count = WordCounter.countCharacters(text)
        }

        resultTextView.text = getString(R.string.result, count)

        resultTextView.text = getString(R.string.result, count)
    }
}
