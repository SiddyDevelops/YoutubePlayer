package com.siddydevelops.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlaySingle.setOnClickListener(this)
        buttonStandalone.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val intent = when(view.id) {
            R.id.buttonPlaySingle -> Intent(this, YoutubeActivity::class.java)
            R.id.buttonStandalone -> Intent(this, StandaloneActivity::class.java)
            else -> throw IllegalArgumentException("Undefined button clicked!")
        }
        startActivity(intent)
    }
}