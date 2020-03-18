package com.example.projectsetup.utils.extentions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.projectsetup.R


/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int, tag: String, transition: Boolean = false, addToBackStack: Boolean = false) {
    supportFragmentManager.transact {
        if (transition) {
            setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
        }
        replace(frameId, fragment, tag)
        if (addToBackStack) {
            addToBackStack(tag)
        }
    }

}

/**
 * The `fragment` is added to the container view with tag. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, frameId: Int, tag: String, transition: Boolean = true) {
    supportFragmentManager.transact {
        if (transition) {
            setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
        }
        add(frameId, fragment, tag)
        addToBackStack(tag)
    }
}

/**
 * Runs a FragmentTransaction, then calls commit().
 */
private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

fun FragmentActivity.transitionActivityStart() {
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

fun FragmentActivity.transitionActivityFinish() {
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun FragmentActivity.transitionActivityLanding() {
    overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
}

fun FragmentActivity.transitionFadeOut() {
    overridePendingTransition(0, R.anim.fade_out_short)
}

/**
 * Method for removing the keyboard if touched outside the editable view.
 *
 * @param view     root view
 */
fun FragmentActivity.setupUI(view: View) {
    //Set up touch listener for non-text box views to hide keyboard.
    if (view !is EditText) {

        view.setOnTouchListener { _, _ ->
            hideSoftKeyboard()
            view.clearFocus()
            false
        }
    }

    //If a layout container, iterate over children and seed recursion.
    if (view is ViewGroup) {
        for (i in 0 until view.childCount) {
            val innerView = view.getChildAt(i)
            setupUI(innerView)
        }
    }
}

fun FragmentActivity.hideSoftKeyboard() {
    // Check if no view has focus: and hide the soft keyboard
    val view = currentFocus
    //Checking if view!=null
    // to prevent java.lang.NullPointerException: Attempt to invoke virtual method 'android.os.IBinder android.view.View.getWindowToken()' on a null object reference
    view?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun EditText.showSoftKeyboard() {
    postDelayed({
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }, 100)
}

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}





