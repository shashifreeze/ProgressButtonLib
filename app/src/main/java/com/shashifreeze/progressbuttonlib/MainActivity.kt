package com.shashifreeze.progressbuttonlib

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.CalendarContract
import com.shashifreeze.progressbutton.ProgressButton
import com.shashifreeze.progressbutton.ProgressLoadingButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pBtn = findViewById<ProgressButton>(R.id.pb)
        pBtn.setOnClickListener {

            pBtn.startProgress("Logging in",bgColor = Color.RED)
            Handler(mainLooper).postDelayed(
                {
                    pBtn.stopProgress("Logged In")

                }, 1000
            )
        }

        val plBtn = findViewById<ProgressLoadingButton>(R.id.plb_btn)
        plBtn.setOnClickListener {

            plBtn.startProgress(bgColor = Color.YELLOW)
            Handler(mainLooper).postDelayed(
                {
                    plBtn.stopProgress("Completed")

                }, 1000
            )
        }

    }
}