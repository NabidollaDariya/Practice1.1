package com.example.practice1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "HelpActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        Log.d(TAG, "onCreate: Экран справки открыт")

        findViewById<Button>(R.id.btnBackHelp).setOnClickListener {
            Log.d(TAG, "Нажата кнопка возврата из справки")
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}