package com.agrongemajli.cse3200_radiovideolab

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.*
import android.util.Log
import android.widget.VideoView
import com.agrongemajli.cse3200_radiovideolab.models.VideoCommands

class BoundVideoService : Service() {

    private lateinit var mMessenger: Messenger
    private lateinit var mVideoView: VideoView
    private var myURI = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_20mb.mp4"


    override fun onCreate() {
        super.onCreate()
        mVideoView = VideoView(this)
        mMessenger = Messenger(IncomingHandler(this.applicationContext))
    }

    // Binder for interacting with the service
    private val mBinder = BoundVideoServiceBinder()

    inner class BoundVideoServiceBinder : Binder() {
        fun getService(): BoundVideoService = this@BoundVideoService
    }

    inner class IncomingHandler(
        context: Context,
        private val applicationContext: Context = context.applicationContext
    ) : Handler() {
        override fun handleMessage(msg: Message) {
            Log.i("AGRON", "Init Message")
            when (msg.what) {
                VideoCommands.START.ordinal -> {
                    Log.i("AGRON", "Message  START!!!")
                    playVideo(myURI)
                }


                VideoCommands.STOP.ordinal ->
                    Log.i("AGRON", "Message  STOP!!!")
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i("AGR", "Message onBind")
        mMessenger = Messenger(IncomingHandler(this))
        return mMessenger.binder
    }

    // Method to start video playback
    fun playVideo(videoUrl: String) {
        Log.i("AGRON", "playing video")
        mVideoView.setVideoURI(Uri.parse(myURI))
        mVideoView.start()
    }

    // Method to pause video playback
    fun pauseVideo() {
        Log.i("AGRON", "paused video")
        mVideoView.pause()
    }

    // Method to stop video playback
    fun stopVideo() {
        Log.i("AGRON", "stopped video")
        mVideoView.stopPlayback()
    }
    // Method for setting the VideoView reference
    fun setVideoView(videoView: VideoView) {
        Log.i("AGRON", "Set the video view for service")
        mVideoView = videoView
    }


}