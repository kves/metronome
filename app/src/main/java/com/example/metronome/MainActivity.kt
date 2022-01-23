package com.example.metronome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        plusImageButton.setOnClickListener {increaseInt()}
        minusImageButton.setOnClickListener {decreaseInt()}
    }

    private fun increaseInt() {
        if (TextUtils.isEmpty(bpmAmountTextNumber.text.toString())){
            bpmAmountTextNumber.setText("1")}
        else
        display(bpmAmountTextNumber.text.toString().toInt()+1)
    }

    private fun decreaseInt() {
        if (TextUtils.isEmpty(bpmAmountTextNumber.text.toString())){
            bpmAmountTextNumber.setText("0")
        }else
        display(bpmAmountTextNumber.text.toString().toInt()-1)

    }

    private fun display (number: Int){
        bpmAmountTextNumber.setText("$number")
    }
}