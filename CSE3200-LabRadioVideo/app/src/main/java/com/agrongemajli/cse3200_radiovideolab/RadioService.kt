package com.agrongemajli.cse3200_radiovideolab

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log

class RadioService : Service() {

    private lateinit var player: MediaPlayer
    private var myUri = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        Log.i("AGR", "HERE")
        setUpRadio(myUri)

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        TODO("Return the communication channel to the service.")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("GSOFTAG", "stopped rservice")
        player.stop()
        player.release()
    }

    fun setUpRadio(uri: String){
        Log.i("GSOFTAG", "setting up rservice")
    player = MediaPlayer().apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
        Log.i("GSOFTAG", "setting up datasource audio")
        setDataSource(applicationContext, Uri.parse(uri))
        Log.i("GSOFTAG", "set the datasource")
        prepare()
        Log.i("GSOFTAG", "preparedAUD")
        start()
    }
    }

}