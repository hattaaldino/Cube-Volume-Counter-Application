package com.antel.codelabhitungbalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editWidth: TextView
    private lateinit var editHeight: TextView
    private lateinit var editLength: TextView
    private lateinit var calculateBtn: Button
    private lateinit var resultTv: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, resultTv.text.toString().trim())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.editHeight = findViewById<TextView>(R.id.edit_height)
        this.editLength = findViewById<TextView>(R.id.edit_length)
        this.editWidth = findViewById<TextView>(R.id.edit_width)
        this.calculateBtn = findViewById<Button>(R.id.calculate_btn)
        this.resultTv = findViewById<TextView>(R.id.tv_result)

        calculateBtn.setOnClickListener {
            val inputLength: String = editLength.text.toString().trim()
            val inputWidth: String = editWidth.text.toString().trim()
            val inputHeight: String = editHeight.text.toString().trim()

            var inputEmpty: Boolean = false

            if(inputLength.isEmpty()) {
                inputEmpty = true
                editLength.error = "Field ini tidak boleh kosong!"
            }

            if(inputWidth.isEmpty()) {
                inputEmpty = true
                editWidth.error = "Field ini tidak boleh kosong!"
            }

            if(inputHeight.isEmpty()) {
                inputEmpty = true
                editHeight.error = "Field ini tidak boleh kosong!"
            }

            if(!inputEmpty) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                resultTv.text = volume.toString()
            }
        }

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            resultTv.text = result
        }
    }
}
