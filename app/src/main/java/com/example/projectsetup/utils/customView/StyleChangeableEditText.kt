package com.example.projectsetup.utils.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import com.example.projectsetup.R


class StyleChangeableEditText : EditText {

    constructor(context: Context) : super(context) {}


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


//    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
//        super.onFocusChanged(focused, direction, previouslyFocusedRect)
//        if (focused) {
//            showSoftKeyboard()
//            this.setBackgroundResource(R.drawable.shp_rect_white_filled)
//            this.setTextAppearance(R.style.EditText_Filled)
//        } else {
//            this.setBackgroundResource(R.drawable.shp_outline_rect_gray)
//            this.setTextAppearance(R.style.EditText_Transparent)
//        }
//    }

}