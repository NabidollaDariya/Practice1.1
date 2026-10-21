package com.example.practice1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Главный экран создан")

        findViewById<Button>(R.id.btnLength).setOnClickListener {
            openConverter("Длина")
        }

        findViewById<Button>(R.id.btnMass).setOnClickListener {
            openConverter("Масса")
        }

        findViewById<Button>(R.id.btnCurrency).setOnClickListener {
            openConverter("Валюта")
        }

        findViewById<Button>(R.id.btnHelp).setOnClickListener {
            Log.i(TAG, "Открытие экрана справки")
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openConverter(category: String) {
        Log.i(TAG, "Переход на экран конвертации. Категория: $category")
        val intent = Intent(this, ConverterActivity::class.java)
        intent.putExtra("EXTRA_CATEGORY", category)
        startActivity(intent)
    }

    // Логирование жизненного цикла
    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}