package com.example.projectsetup.utils.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.example.projectsetup.utils.contracts.AppContracts.Strings.CURRENCY
import java.text.NumberFormat
import java.util.*


class CurrencyTextView : TextView {

    constructor(context: Context) : super(context) {
        setCurrency()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setCurrency()
    }


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setCurrency()
    }

    /**
     * Set Currency Format for the amount**/

    private fun setCurrency() {
        val formattedText = NumberFormat.getNumberInstance(Locale.US).format(text.toString().toDouble())
        text = String.format("$CURRENCY %s", formattedText)
    }

    /**
     * Returns amount without the currency and comma separators**/

    override fun getText(): CharSequence {
        val normalText = super.getText().toString()
        normalText.replace(",", "")
        normalText.replace("$", "")
        return normalText
    }
}