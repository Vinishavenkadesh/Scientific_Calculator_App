package com.example.scientific_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.os.Bundle
import com.example.scientific_calculator_app.R
import android.text.SpannableStringBuilder
import android.view.View
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private var previousCalculator: TextView? = null
    private var display: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previousCalculator = findViewById(R.id.previousCalculationView)
        display = findViewById(R.id.displayEditText)
        display!!.setShowSoftInputOnFocus(false)
    }

    private fun updateText(strToAdd: String) {
        val oldStr = display!!.text.toString()
        val cursorPos = display!!.selectionStart
        val leftStr = oldStr.substring(0, cursorPos)
        val rightStr = oldStr.substring(cursorPos)
        display!!.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
        display!!.setSelection(cursorPos + strToAdd.length)
    }

    fun zeroBTNPush(view: View?) {
        updateText(resources.getString(R.string.zeroText))
    }

    fun oneBTNPush(view: View?) {
        updateText(resources.getString(R.string.oneText))
    }

    fun twoBTNPush(view: View?) {
        updateText(resources.getString(R.string.twoText))
    }

    fun threeBTNPush(view: View?) {
        updateText(resources.getString(R.string.threeText))
    }

    fun fourBTNPush(view: View?) {
        updateText(resources.getString(R.string.fourText))
    }

    fun fiveBTNPush(view: View?) {
        updateText(resources.getString(R.string.fiveText))
    }

    fun sixBTNPush(view: View?) {
        updateText(resources.getString(R.string.sixText))
    }

    fun sevenBTNPush(view: View?) {
        updateText(resources.getString(R.string.sevenText))
    }

    fun eightBTNPush(view: View?) {
        updateText(resources.getString(R.string.eightText))
    }

    fun nineBTNPush(view: View?) {
        updateText(resources.getString(R.string.nineText))
    }

    fun multiplyBTNPush(view: View?) {
        updateText(resources.getString(R.string.multiplyText))
    }

    fun dividePush(view: View?) {
        updateText(resources.getString(R.string.divideText))
    }

    fun subtractBTNPush(view: View?) {
        updateText(resources.getString(R.string.subtractText))
    }

    fun addBTNPush(view: View?) {
        updateText(resources.getString(R.string.addText))
    }

    fun clearBTNPush(view: View?) {
        display!!.setText("")
        previousCalculator!!.text = ""
    }

    fun parOpenBTNPush(view: View?) {
        updateText(resources.getString(R.string.parenthesesOpenText))
    }

    fun parCloseBTNPush(view: View?) {
        updateText(resources.getString(R.string.parenthesesCloseText))
    }

    fun decimalBTNPush(view: View?) {
        updateText(resources.getString(R.string.decimalText))
    }

    fun equalBTNPush(view: View?) {
        var userExp = display!!.text.toString()
        previousCalculator!!.text = userExp
        userExp = userExp.replace(resources.getString(R.string.divideText).toRegex(), "/")
        userExp = userExp.replace(resources.getString(R.string.multiplyText).toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display!!.setText(result)
        display!!.setSelection(result.length)
    }

    fun backspaceBTNPush(view: View?) {
        val cursorPos = display!!.selectionStart
        val textLen = display!!.text.length
        if (cursorPos != 0 && textLen != 0) {
            val selection = display!!.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            display!!.text = selection
            display!!.setSelection(cursorPos - 1)
        }
    }

    fun trigSinBTNPush(view: View?) {
        updateText("sin(")
    }

    fun trigCosBTNPush(view: View?) {
        updateText("cos(")
    }

    fun trigTanBTNPush(view: View?) {
        updateText("tan(")
    }

    fun trigArcSinBTNPush(view: View?) {
        updateText("arcsin(")
    }

    fun trigArcCosBTNPush(view: View?) {
        updateText("arccos(")
    }

    fun trigArcTanBTNPush(view: View?) {
        updateText("arctan(")
    }

    fun naturalLogBTNPush(view: View?) {
        updateText("ln(")
    }

    fun LogBTNPush(view: View?) {
        updateText("log(")
    }

    fun squareRootBTNPush(view: View?) {
        updateText("sqrt(")
    }

    fun absoluteValueBTNPush(view: View?) {
        updateText("abs(")
    }

    fun piBTNPush(view: View?) {
        updateText("pi")
    }

    fun eBTNPush(view: View?) {
        updateText("e")
    }

    fun xSquaredBTNPush(view: View?) {
        updateText("^(2)")
    }

    fun xPowerYBTNPush(view: View?) {
        updateText("^(")
    }

    fun isPrimeFunctionBTNPush(view: View?) {
        updateText("ispr(")
    }
}