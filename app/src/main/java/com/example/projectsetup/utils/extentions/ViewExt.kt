package com.example.projectsetup.utils.extentions

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.os.Build
import android.text.Html
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.projectsetup.R
import com.example.projectsetup.utils.contracts.AppContracts



fun Context.showAlert(message: String?) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setMessage(message)
            .setPositiveButton(AppContracts.Strings.ok) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
}

fun Context.showToast(message: String?) {
    Toast.makeText(this, message ?: "", Toast.LENGTH_SHORT).show()
}

fun Context.showNotCancellableAlert(message: String,
                                    action: () -> Unit = {}) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setMessage(message)
            .setPositiveButton(AppContracts.Strings.ok) { dialog, _ ->
                dialog.dismiss()
                action()
            }
    val alertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}

fun Context.showConfirmationDialog(message: String,
                                   positiveButton: String = AppContracts.Strings.ok,
                                   negativeButton: String = AppContracts.Strings.cancel,
                                   negativeAction: () -> Unit = {},
                                   positiveAction: () -> Unit
): AlertDialog.Builder {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setTitle("")
            .setMessage(message)
            .setPositiveButton(positiveButton) { dialog, _ ->
                dialog.dismiss()
                positiveAction()
            }
            .setNegativeButton(negativeButton) { dialog, _ ->
                dialog.dismiss()
                negativeAction()
            }

    return builder
}

fun Context.showNonConfirmationDialog(message: String,
                                      positiveButton: String = AppContracts.Strings.ok,
                                      negativeButton: String = AppContracts.Strings.cancel,
                                      negativeAction: () -> Unit = {},
                                      positiveAction: () -> Unit
) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setTitle(R.string.app_name)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positiveButton) { dialog, _ ->
                dialog.dismiss()
                positiveAction()
            }
            .setNegativeButton(negativeButton) { dialog, _ ->
                dialog.dismiss()
                negativeAction()
            }
            .show()
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.showToast(message: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun TextView.fromHtml(html: String) {
    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        Html.fromHtml(html)
    }
}

fun TextView.underline() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

fun pxToDp(px: Float): Float {
    val densityDpi = Resources.getSystem().displayMetrics.densityDpi.toFloat()
    return px / (densityDpi / 160f)
}

fun dpToPx(dp: Float): Int {
    val density = Resources.getSystem().displayMetrics.density
    return Math.round(dp * density)
}

val Float.toPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()


