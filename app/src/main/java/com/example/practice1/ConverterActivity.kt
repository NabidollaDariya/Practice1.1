package com.example.practice1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConverterActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ConverterActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
        Log.d(TAG, "onCreate: Экран конвертации создан")

        val category = intent.getStringExtra("EXTRA_CATEGORY") ?: "Неизвестно"
        Log.d(TAG, "Получена категория: $category")

        val tvCategoryTitle = findViewById<TextView>(R.id.tvCategoryTitle)
        val etInputValue = findViewById<EditText>(R.id.etInputValue)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnBack = findViewById<Button>(R.id.btnBackConverter)

        tvCategoryTitle.text = category

        btnConvert.setOnClickListener {
            val inputStr = etInputValue.text.toString()
            if (inputStr.isEmpty()) {
                Log.w(TAG, "Поле ввода пустое")
                tvResult.text = "Ошибка: введите число"
                return@setOnClickListener
            }

            try {
                val inputValue = inputStr.toDouble()
                var resultValue = 0.0
                var unit = ""

                when (category) {
                    "Длина" -> { resultValue = inputValue * 100; unit = "см" } // Метры в Сантиметры
                    "Масса" -> { resultValue = inputValue * 1000; unit = "г" } // КГ в Граммы
                    "Валюта" -> { resultValue = inputValue * 450; unit = "KZT" } // Примерный курс USD
                }

                tvResult.text = "Результат: $resultValue $unit"
                Log.i(TAG, "Успешная конвертация: $inputValue -> $resultValue $unit")
            } catch (e: Exception) {
                Log.e(TAG, "Ошибка при конвертации", e)
                tvResult.text = "Ошибка формата"
            }
        }

        btnBack.setOnClickListener {
            Log.d(TAG, "Нажата кнопка Назад")
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}