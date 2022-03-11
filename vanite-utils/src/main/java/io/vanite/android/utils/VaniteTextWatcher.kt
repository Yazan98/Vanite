package io.vanite.android.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import io.vanite.android.utils.impl.VaniteTextWatcherAfter

fun EditText.addVaniteTextWatcher(listener: VaniteTextWatcherAfter) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        override fun afterTextChanged(s: Editable?) {
            listener.onTextFinished(s)
        }
    })
}

fun TextInputEditText.addVaniteTextWatcher(listener: VaniteTextWatcherAfter) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        override fun afterTextChanged(s: Editable?) {
            listener.onTextFinished(s)
        }
    })
}
