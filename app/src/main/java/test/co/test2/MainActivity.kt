package test.co.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var customEditText: CustomEditText
    private lateinit var customSeekBar: CustomSeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customEditText = findViewById(R.id.customEditText)
        customSeekBar = findViewById(R.id.customSeekBar)

        customEditText.setOnValueChangedListener(object : CustomEditText.OnValueChangedListener {
            override fun onValueChanged(value: Int) {
                Log.d("CEKK", "CUSTOM EDITTEXT: $value")
                val progress = if (value >= 30000000) {
                    60
                } else {
                    (value * 60) / 30000000
                }
                customSeekBar.progress = progress
            }
        })

        customSeekBar.setOnValueChangedListener(object : CustomSeekBar.OnValueChangedListener {
            override fun onValueChanged(value: Int) {
                Log.d("CEKK", "CUSTOM SEEKBAR: $value")
                val editTextValue = (value.toDouble() / 60) * 30000000
                customEditText.setText(editTextValue.toInt().toString())
            }
        })
    }
}