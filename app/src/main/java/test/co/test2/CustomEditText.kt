package test.co.test2

import android.content.Context
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.addTextChangedListener

class CustomEditText : AppCompatEditText {
    private var onValueChangedListener: OnValueChangedListener? = null
    private var textWatcher: TextWatcher? = null

    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }

    private fun initialize() {
        // Konfigurasi EditText kustom di sini
        inputType = InputType.TYPE_CLASS_NUMBER
        textWatcher = object : SimpleTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val value = s.toString().toDoubleOrNull() ?: 0.0
                onValueChangedListener?.onValueChanged((value).toInt())
            }
        }
        addTextChangedListener(textWatcher)
    }

    fun setOnValueChangedListener(listener: OnValueChangedListener) {
        onValueChangedListener = listener
    }

    fun removeOnValueChangedListener() {
        removeTextChangedListener(textWatcher)
    }

    interface OnValueChangedListener {
        fun onValueChanged(value: Int)
    }
}
