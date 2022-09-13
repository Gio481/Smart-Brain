package com.example.smartbraincomponents.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat

fun EditText.textChangedListener(
    beforeTextChanged: ((text:String, start: Int, count: Int, after: Int) -> Unit)? = null,
    onTextChanged: ((String, start: Int, before: Int, count: Int) -> Unit)? = null,
    afterTextChanged: ((String) -> Unit)? = null,
) {

    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChanged?.invoke(text.toString(), start, count, after)
        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            if (count > 1) {
                onTextChanged?.invoke(text.toString().last().toString(), start, before, count)
            } else {
                onTextChanged?.invoke(text.toString(), start, before, count)
            }
        }

        override fun afterTextChanged(text: Editable?) {
            afterTextChanged?.invoke(text.toString())
        }
    })
}

fun EditText.getTextColor(color: Int) {
    this.setTextColor(ContextCompat.getColor(this.context, color))
}