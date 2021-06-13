package com.fathi.wisatacirebon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class vidio : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {


    lateinit var yt :YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vidio)

        yt = findViewById(R.id.youtube)
        yt.initialize("AIzaSyB4KoO62z33V7SDxhjzUCNWtcmkQFcwhAw",this)
    }


    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {

        p1!!.setFullscreen(true)
        p1.cueVideo("gI9dI0VG9YU")
        p1.play()

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1!!.isUserRecoverableError){
            p1.getErrorDialog(this,1).show()
        }

    }
}
