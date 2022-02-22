package com.siddydevelops.youtubeplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YOUTUBE_VIDEO_ID = "nG_Vydox0v8"
const val YOUTUBE_PLAYLIST = "PLBlnK6fEyqRiVhbXDGLXDk_OQAeuVcp2O"

class YoutubeActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_youtube)
//        val layout = findViewById<ConstraintLayout>(R.id.activity_youtube)
        val layout = layoutInflater.inflate(R.layout.activity_youtube,null) as ConstraintLayout
        setContentView(layout)

        // Adding Buttons through program
//        val button1 = Button(this)
//        button1.layoutParams = ConstraintLayout.LayoutParams(600,180)
//        button1.text = "Button Added"
//        layout.addView(button1)

        val playerView = YouTubePlayerView(this)
        playerView.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        layout.addView(playerView)

    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?,p1: YouTubePlayer?,p2: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?,p1: YouTubeInitializationResult?) {
        TODO("Not yet implemented")
    }
}