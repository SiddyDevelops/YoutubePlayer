package com.siddydevelops.youtubeplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
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

        playerView.initialize(getString(R.string.GOOGLE_API_KEY), this)

    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?,youtubePlayer: YouTubePlayer?,wasRestored: Boolean) {

        youtubePlayer?.setPlayerStateChangeListener(playerStateChangeListner)
        youtubePlayer?.setPlaybackEventListener(playbackEventListener)
        if(!wasRestored) {
            youtubePlayer?.cueVideo(YOUTUBE_VIDEO_ID)
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?,youTubeInitializationResult: YouTubeInitializationResult?) {
        val REQUEST_CODE = 0
        if(youTubeInitializationResult?.isUserRecoverableError == true) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show()
        } else {
            val errorMessage = "There was an error initializing the Youtube $youTubeInitializationResult"
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()
        }
    }

    private val playbackEventListener = object: YouTubePlayer.PlaybackEventListener {
        override fun onPlaying() {
            Toast.makeText(this@YoutubeActivity,"Good, video is playing.",Toast.LENGTH_LONG).show()
        }

        override fun onPaused() {
            Toast.makeText(this@YoutubeActivity,"Video is paused.",Toast.LENGTH_LONG).show()
        }

        override fun onStopped() {
            Toast.makeText(this@YoutubeActivity,"Video is stopped.",Toast.LENGTH_LONG).show()
        }

        override fun onBuffering(p0: Boolean) {

        }

        override fun onSeekTo(p0: Int) {

        }

    }

    private val playerStateChangeListner = object: YouTubePlayer.PlayerStateChangeListener {
        override fun onLoading() {

        }

        override fun onLoaded(p0: String?) {

        }

        override fun onAdStarted() {

        }

        override fun onVideoStarted() {
            Toast.makeText(this@YoutubeActivity,"Video is Started.",Toast.LENGTH_LONG).show()
        }

        override fun onVideoEnded() {
            Toast.makeText(this@YoutubeActivity,"Video is Completed.",Toast.LENGTH_LONG).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {

        }

    }

}