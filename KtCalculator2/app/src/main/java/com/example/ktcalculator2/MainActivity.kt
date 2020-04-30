package com.example.ktcalculator2

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //vars for Calculation
    private var number1 = 0.0
    private var number2 = 0.0
    private var output: Double? = null
    private var operation: String? = null
    private var num1: String? = null
    private var num2: String? = null
    private var dot: String? = null
    private var out: String? = null
    private var dots = "."
    private var sign: Boolean? = null

    //vars for number buttons
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button

    //vars for operation buttons
    private lateinit var equal: Button
    private lateinit var comma: Button
    private lateinit var delete: Button
    private lateinit var clear: Button
    private lateinit var divide: Button
    private lateinit var multiply: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var root: Button
    private lateinit var exp: Button
//    private lateinit var e: Button
//    private lateinit var cos: Button
//    private lateinit var sin: Button
//    private lateinit var tan: Button
//    private lateinit var ln: Button
//    private lateinit var log: Button
//    private lateinit var pi: Button
//    private lateinit var percent: Button
    private lateinit var mainText: TextView
    private lateinit var secondaryText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewInitialization()

        operation = ""
        sign = false
        num2 = ""
        dot = ""
        number1 = 0.0
        number2 = 0.0
        output = 0.0
        out = ""
        dots = "."

        zero.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        equal.setOnClickListener(this)
        comma.setOnClickListener(this)
        delete.setOnClickListener(this)
        clear.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiply.setOnClickListener(this)
        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        plus.setOnClickListener(this)
        root.setOnClickListener(this)
        exp.setOnClickListener(this)
    }

    private fun viewInitialization() {
        zero = findViewById(R.id.bt0)
        one = findViewById(R.id.bt1)
        two = findViewById(R.id.bt2)
        three = findViewById(R.id.bt3)
        four = findViewById(R.id.bt4)
        five = findViewById(R.id.bt5)
        six = findViewById(R.id.bt6)
        seven = findViewById(R.id.bt7)
        eight = findViewById(R.id.bt8)
        nine = findViewById(R.id.bt9)

        equal = findViewById(R.id.btEqual)
        comma = findViewById(R.id.btDot)
        delete = findViewById(R.id.btDelete)
        clear = findViewById(R.id.btClear)
        divide = findViewById(R.id.btDivision)
        multiply = findViewById(R.id.btMultiplication)
        minus = findViewById(R.id.btMinus)
        plus = findViewById(R.id.btPlus)
        root = findViewById(R.id.btRoot)
        exp = findViewById(R.id.btExp)
        mainText = findViewById(R.id.tvMainText)
        secondaryText = findViewById(R.id.tvSecondaryText)
    }

    override fun onClick(v: View?) {

        var value = mainText.text.toString()

        when (v!!.id) {
            R.id.btDelete -> {
                secondaryText.text = ""
                if (value != "") {
                    value = value.substring(0, value.length - 1)
                    mainText.text = value
                }
            }
            R.id.btClear -> {
                mainText.text = ""
                secondaryText.text = ""
            }
            R.id.btDivision -> {
                if (value != "") {
                    if (!sign!!) {
                        secondaryText.text = ""
                        sign = true
                        num1 = mainText.text.toString()
                        mainText.text = ""
                        operation = "/"
                    } else {
                        operation = "/"
                    }
                }
            }
            R.id.btMultiplication -> {
                if (value != "") {
                    if (!sign!!) {
                        secondaryText.text = ""
                        sign = true
                        num1 = mainText.text.toString()
                        mainText.text = ""
                        operation = "*"
                    } else {
                        operation = "*"
                    }
                }
            }
            R.id.btPlus -> {
                if (value != "") {
                    if (!sign!!) {
                        secondaryText.text = ""
                        sign = true
                        num1 = mainText.text.toString()
                        mainText.text = ""
                        operation = "+"
                    } else {
                        operation = "+"
                    }
                }
            }
            R.id.btMinus -> {
                if (value != "") {
                    if (!sign!!) {
                        secondaryText.text = ""
                        sign = true
                        num1 = mainText.text.toString()
                        mainText.text = ""
                        operation = "-"
                    } else {
                        operation = "-"
                    }
                }
            }
            R.id.btExp -> {
                if (value != "") {
                    if (!sign!!) {
                        secondaryText.text = ""
                        sign = true
                        num1 = mainText.text.toString()
                        mainText.text = ""
                        operation = "^"
                    } else {
                        operation = "^"
                    }
                }
            }


            R.id.btEqual -> {
                secondaryText.setTextColor(Color.rgb(255, 255, 255))
                if (value != "") {
                    if (operation.toString() == "+") {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        secondaryText.text = (number1 + number2).toString()
                        operation = ""
                        sign = false
                    }
                    if (operation.equals("-")) {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        secondaryText.text = (number1 - number2).toString()
                        operation = ""
                        sign = false
                    }
                    if (operation.equals("*")) {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        secondaryText.text = (number1 * number2).toString()
                        operation = ""
                        sign = false
                    }
                    if (operation.equals("/")) {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        if (number1 == 0.0 || number2 == 0.0) {
                            secondaryText.setTextColor(Color.rgb(249, 174, 171))
                            secondaryText.text = "На 0 делить нельзя"
                        } else {
                            secondaryText.text = (number1 / number2).toString()
                            operation = ""
                        }
                        operation = ""
                        sign = false
                    }
                    if (operation.equals("^")) {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        secondaryText.text = (number1.pow(number2)).toString()
                        operation = ""
                        sign = false
                    }
                    if (operation.equals("%")) {
                        num2 = mainText.text.toString()
                        number1 = num1!!.toDouble()
                        number2 = num2!!.toDouble()
                        val percent =number2/100
                        secondaryText.text = (number1*percent).toString()
                        operation = ""
                        sign = false
                    }
                    tvMainText.text = ""
                }
            }
            R.id.btDot -> {
                secondaryText.text = ""
                if (mainText.text.contains(dots)) {
                    mainText.append(".")
                }
            }
            R.id.btRoot -> {
                if (mainText.text != "") {
                    num1 = mainText.text.toString()
                    number1 = num1!!.toDouble()
                    secondaryText.text = (sqrt(number1)).toString()
                    mainText.text = ""
                }
            }


            R.id.bt1 -> {
                if (value == "0") {
                    mainText.text = "1"
                } else {
                    mainText.append("1")
                }
                secondaryText.text = ""
            }
            R.id.bt2 -> {
                if (value == "0") {
                    mainText.text = "2"
                } else {
                    mainText.append("2")
                }
                secondaryText.text = ""
            }
            R.id.bt3 -> {
                if (value == "0") {
                    mainText.text = "3"
                } else {
                    mainText.append("3")
                }
                secondaryText.text = ""
            }
            R.id.bt4 -> {
                if (value == "0") {
                    mainText.text = "4"
                } else {
                    mainText.append("4")
                }
                secondaryText.text = ""
            }
            R.id.bt5 -> {
                if (value == "0") {
                    mainText.text = "5"
                } else {
                    mainText.append("5")
                }
                secondaryText.text = ""
            }
            R.id.bt6 -> {
                if (value == "0") {
                    mainText.text = "6"
                } else {
                    mainText.append("6")
                }
                secondaryText.text = ""
            }
            R.id.bt7 -> {
                if (value == "0") {
                    mainText.text = "7"
                } else {
                    mainText.append("7")
                }
                secondaryText.text = ""
            }
            R.id.bt8 -> {
                if (value == "0") {
                    mainText.text = "8"
                } else {
                    mainText.append("8")
                }
                secondaryText.text = ""
            }
            R.id.bt9 -> {
                if (value == "0") {
                    mainText.text = "9"
                } else {
                    mainText.append("9")
                }
                secondaryText.text = ""
            }
            R.id.bt0 -> {
                if (value != "0") {
                    mainText.append("0")
                }
                secondaryText.text = ""
            }
        }
    }

    fun pressSin(view: View) {
        if (mainText.text != "") {
            num1 = mainText.text.toString()
            number1 = num1!!.toDouble()
            secondaryText.text = (sin(number1)).toString()
            mainText.text = ""
        }
    }

    fun pressCos(view: View) {
        if (mainText.text != "") {
            num1 = mainText.text.toString()
            number1 = num1!!.toDouble()
            secondaryText.text = (cos(number1)).toString()
            mainText.text = ""
        }
    }

    fun pressTan(view: View) {
        if (mainText.text != "") {
            num1 = mainText.text.toString()
            number1 = num1!!.toDouble()
            secondaryText.text = (tan(number1)).toString()
            mainText.text = ""
        }
    }

    fun pressLn(view: View) {
        if (mainText.text != "") {
            num1 = mainText.text.toString()
            number1 = num1!!.toDouble()
            secondaryText.text = (log(number1, 2.0)).toString()
            mainText.text = ""
        }
    }

    fun pressLog(view: View) {
        if (mainText.text != "") {
            num1 = mainText.text.toString()
            number1 = num1!!.toDouble()
            secondaryText.text = (log10(number1)).toString()
            mainText.text = ""
        }
    }

    fun pressPI(view: View) {
        if (mainText.text != "") {
            secondaryText.text = PI.toString()
            mainText.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    fun pressE(view: View) {
        if (mainText.text != "") {
            val e = "2,718281828459045235360"
            secondaryText.text = e.toString()
            mainText.text = ""
        }
    }

    fun pressPercent(view: View) {
        var value = mainText.text.toString()
        if (value != "") {
            if (!sign!!) {
                secondaryText.text = ""
                sign = true
                num1 = mainText.text.toString()
                mainText.text = ""
                operation = "%"
            } else {
                operation = "%"
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("operation", operation)
        outState.putString("number1", num1)
        outState.putString("text", mainText.text.toString())
        outState.putString("out", secondaryText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        mainText.append(savedInstanceState.getString("text"))
        secondaryText.append(savedInstanceState.getString("out"))
        operation = savedInstanceState.getString("operation")
        num1 = savedInstanceState.getString("number1")
    }
}
