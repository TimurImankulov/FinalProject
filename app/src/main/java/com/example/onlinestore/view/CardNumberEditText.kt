package com.example.onlinestore.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CardNumberEditText(context: Context, attributeSet: AttributeSet) :
    AppCompatEditText(context, attributeSet) {

    private val CARD_NUMBER_TOTAL_SYMBOLS = 19 // size of pattern 0000-0000-0000-0000
    private val CARD_NUMBER_TOTAL_DIGITS = 16 // max numbers of digits in pattern: 0000 x 4
    private val CARD_NUMBER_DIVIDER_MODULO = 5 // means divider position is every 5th symbol beginning with 1
    private val CARD_NUMBER_DIVIDER_POSITION = CARD_NUMBER_DIVIDER_MODULO - 1 // means divider position is every 4th symbol beginning with 0
    private val CARD_NUMBER_DIVIDER = ' '

    private val textChanheLisnter = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable) {
            if (!isInputCorrect(
                    s,
                    CARD_NUMBER_TOTAL_SYMBOLS,
                    CARD_NUMBER_DIVIDER_MODULO,
                    CARD_NUMBER_DIVIDER
                )) {
                s.replace(
                    0, s.length, concatString(
                        getDigitArray(s, CARD_NUMBER_TOTAL_DIGITS),
                        CARD_NUMBER_DIVIDER_POSITION,
                        CARD_NUMBER_DIVIDER
                    )
                );
            }
        }

        private fun concatString(digits: CharArray, dividerPosition: Int, divider: Char): String? {
            val formatted = StringBuilder()
            for (i in digits.indices) {
                if (digits[i].toInt() != 0) {
                    formatted.append(digits[i])
                    if (i > 0 && i < digits.size - 1 && (i + 1) % dividerPosition == 0) {
                        formatted.append(divider)
                    }
                }
            }
            return formatted.toString()
        }
    }

    fun getNormalString(): String {
        return this.text.toString().replace(CARD_NUMBER_DIVIDER.toString(), "", ignoreCase = true)
    }

    fun getCardString(): String {
        return this.text.toString()
    }

    private fun isInputCorrect(
        s: Editable,
        size: Int,
        dividerPosition: Int,
        divider: Char
    ): Boolean {
        var isCorrect = s.length <= size
        for (i in s.indices) {
            isCorrect = if (i > 0 && (i + 1) % dividerPosition == 0) {
                isCorrect and (divider == s[i])
            } else {
                isCorrect and Character.isDigit(s[i])
            }
        }
        return isCorrect
    }

    init {
        addTextChangedListener(textChanheLisnter)
    }

    private fun getDigitArray(s: Editable, size: Int): CharArray {
        val digits = CharArray(size)
        var index = 0
        var i = 0
        while (i < s.length && index < size) {
            val current = s[i]
            if (Character.isDigit(current)) {
                digits[index] = current
                index++
            }
            i++
        }
        return digits
    }
}