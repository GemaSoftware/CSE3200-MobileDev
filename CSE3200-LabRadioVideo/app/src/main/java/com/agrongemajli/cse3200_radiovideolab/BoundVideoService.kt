package com.agrongemajli.cse3200_radiovideolab

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.*
import android.util.Log
import android.view.SurfaceHolder
import android.widget.VideoView
import com.agrongemajli.cse3200_radiovideolab.models.VideoCommands

class BoundVideoService : Service() {

    private lateinit var mMediaPlayer: MediaPlayer
    private lateinit var mSurfaceHolder: SurfaceHolder
    private var myURI = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_20mb.mp4"

    private val binder = BoundVideoServiceBinder()
    private var setState: Boolean = false


    override fun onCreate() {
        super.onCreate()
        mMediaPlayer = MediaPlayer()
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i("GSOFTAG", "BVS onBind")
        return binder
    }

    // Method to start video playback
    fun playVideo() {
        Log.i("GSOFTAG", "playing video")
        if(!setState){
            mMediaPlayer.setDataSource(this, Uri.parse(myURI))
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
            mMediaPlayer.setVolume(0f, 0f)
            mMediaPlayer.prepareAsync()
            mMediaPlayer.setOnPreparedListener { mp ->
                mMediaPlayer.start()
            }
            setState = true
        } else {
            mMediaPlayer.start()
        }
    }

    // Method to pause video playback
    fun pauseVideo() {
        Log.i("GSOFTAG", "paused video")
        mMediaPlayer.pause()
    }

    // Method to stop video playback
    fun stopVideo() {
        Log.i("GSOFTAG", "stopped video")
        mMediaPlayer.stop()
    }
    // Method for setting the VideoView reference. This can only be done with MainActivity if they are on the same process.
    fun setSurfaceHolder(videoView: SurfaceHolder) {
        Log.i("GSOFTAG", "Set the video view for service")
        mSurfaceHolder = videoView
        mMediaPlayer.setDisplay(mSurfaceHolder)

    }

    inner class BoundVideoServiceBinder : Binder() {
        fun getService(): BoundVideoService = this@BoundVideoService
    }


}