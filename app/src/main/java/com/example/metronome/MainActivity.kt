package com.example.metronome

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bpmAmountTextNumber.transformationMethod = HideReturnsTransformationMethod.getInstance()
        plusImageButton.setOnClickListener {increaseInt()}
        minusImageButton.setOnClickListener {decreaseInt()}
        startStopButton.setOnClickListener {startBeat()}
    }

    private fun increaseInt() {
        if (TextUtils.isEmpty(bpmAmountTextNumber.text.toString())){
            bpmAmountTextNumber.setText("1")}
        else
        display(bpmAmountTextNumber.text.toString().toInt()+1)
    }

    private fun decreaseInt() {
        when {
            TextUtils.isEmpty(bpmAmountTextNumber.text.toString()) -> {
                bpmAmountTextNumber.setText("0")
            }
            bpmAmountTextNumber.text.toString() == "0" -> {
                bpmAmountTextNumber.setText("0")
            }
            else -> display(bpmAmountTextNumber.text.toString().toInt()-1)
        }

    }

    private fun display (number: Int){
        bpmAmountTextNumber.setText("$number")
    }

    private fun startBeat (){
        if (startStopButton.text.toString() == "START"){
            startStopButton.text = "STOP"
            startStopButton.setBackgroundResource(R.drawable.stop_button)

             //while (startStopButton.text.toString() == "STOP"){
             //   var breakTime: Long = 60/bpmAmountTextNumber.text.toString().toLong()
            //    Timer().schedule(breakTime){
            //        playSound()
            //     }
            // }
        }else{
            startStopButton.text = "START"
            startStopButton.setBackgroundResource(R.drawable.start_button)
            stopSound()
        }
       // while (startStopButton.text.toString() == "STOP"){
        //    var breakTime: Long = 60/bpmAmountTextNumber.text.toString().toLong()
        //    Timer().schedule(breakTime){
        //        playSound()
       //     }
       // }
    }

    fun playSound() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.metronome_sound)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }


}