package com.imaginato.homeworkmvp.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(stringResId: Int) =
    Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show()

fun Context.toastLong(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toastLong(stringResId: Int) =
    Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show()

fun showViews(vararg views: View?) {
    for (v in views) {
        if (v != null && v.getVisibility() !== View.VISIBLE) {
            v.visibility = View.VISIBLE
        }
    }
}

fun hideViews(vararg views: View?) {
    for (v in views) {
        if (v != null && v.getVisibility() !== View.GONE) {
            if (v.getAnimation() != null) {
                v.clearAnimation()
            }
            v.visibility = View.GONE
        }
    }
}