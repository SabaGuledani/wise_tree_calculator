package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvClear: TextView
    private var operand = 0.0
    private var operation = ""
    lateinit var dot: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.resultTV)
        tvClear = findViewById(R.id.resultTV)
        dot = findViewById(R.id.dot)
    }

    fun numberclick(clickedView: View) {
        if (tvResult.text.toString() != "Infinity" && tvResult.text.toString() != "NaN") {
            if (tvResult.text.toString().length <= 12) {


                if (clickedView is TextView) {
                    var text = tvResult.text.toString()
                    var number = clickedView.text.toString()
                    if (text == "0") {
                        text = ""
                    }
                    val result = text + number
                    tvResult.text = result

                }
            }
        }
    }

    fun clearclick(clickedView: View) {
        tvResult.text = "0"
        operand = 0.0

    }

    fun delclick(clickedView: View) {
        if (tvResult.text.toString() != "Infinity" && tvResult.text.toString() != "NaN") {
            var temp = tvResult.text.toString()
            tvResult.text = temp.dropLast(1)
            if (tvResult.text == "") {
                tvResult.text = "0"
                operand = 0.0
            }
        }
    }

    fun dotclick(clickedView: View) {
        if (tvResult.text.toString() != "Infinity" && tvResult.text.toString() != "NaN") {
            if ("." !in tvResult.text.toString()) {
                if (clickedView is TextView) {
                    var dot = clickedView.text.toString()
                    var num = tvResult.text.toString()

                    val result = num + dot
                    tvResult.text = result
                }
            }
        }
    }

    fun operationclick(clickedView: View) {
        if (tvResult.text.toString() != "Infinity" && tvResult.text.toString() != "NaN") {
            if (clickedView is TextView) {

                if (tvResult.text.toString() != "") {
                    operand = tvResult.text.toString().toDouble()
                    operation = clickedView.text.toString()
                    tvResult.text = ""

                } else {
                    operation = clickedView.text.toString()
                }
            }
        }
    }


    fun equalsclick(clickedView: View) {
        var result = ""

            if (tvResult.text.toString() != "" && operation != "") {
                var secondOperand = tvResult.text.toString().toDouble()

                when (operation) {
                    "+" -> result = (operand + secondOperand).toString()
                    "-" -> result = (operand - secondOperand).toString()
                    "*" -> result = (operand * secondOperand).toString()
                    "/" -> result = (operand / secondOperand).toString()
                }

                if (result.toDouble() == result.toDouble().toInt().toDouble()) {
                    tvResult.text = result.toDouble().toInt().toString()
                } else {
                    tvResult.text = result
                }
            }
        }
    }



















