package com.wear.hey.heyfirstwearapp

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

typealias OnClickListenerProvider = (View) -> Unit
typealias CounterTicker = (Int) -> Int

class MainActivity : WearableActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        logDebug("entered")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        // setAmbientEnabled()

        logInfo("Started application")

        val counter: TextView = findViewById(R.id.counter)
        val minusButton: ImageButton = findViewById(R.id.btn_minus)

        minusButton.setOnClickListener(getOnClickListener(counter, { it - 1 }))

        val plusButton: ImageButton = findViewById(R.id.btn_plus)
        plusButton.setOnClickListener(getOnClickListener(counter, { it + 1 }))

        logDebug("Setup finished")
    }

    private fun getOnClickListener(counter: TextView, ticker: CounterTicker): OnClickListenerProvider {
        return {
            val counterValue = counter.text.toString()
            logInfo("previous counterValue: $counterValue")
            counter.text = ticker(Integer.valueOf(counterValue)).toString()
        }
    }

    private fun logInfo(msg: String) {
        Log.i(TAG, msg)
    }

    private fun logDebug(msg: String) {
        Log.d(TAG, msg)
    }
}
