package com.agrongemajli.cse3200_radiovideolab

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import com.agrongemajli.cse3200_radiovideolab.databinding.ActivityMainBinding
import com.agrongemajli.cse3200_radiovideolab.models.VideoCommands

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var messenger: Messenger? = null
    private lateinit var msg: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startRadioServiceButton.setOnClickListener {
            Log.i("AGR", "Clicked Button for service")
            //startService(Intent(this, RadioService::class.java))
            msg = Message.obtain(null, VideoCommands.START.ordinal, 4, -5)
            messenger?.send(msg)
            msg.recycle()

        }
        binding.stopRadioServiceButton.setOnClickListener {
            //stopService(Intent(this, RadioService::class.java))
            msg = Message.obtain(null, VideoCommands.STOP.ordinal, 4, -5)
            messenger?.send(msg)
            msg.recycle()
        }

    }

    override fun onStart() {
        super.onStart()
        bindService(Intent(this, BoundVideoService::class.java), connection, Context.BIND_AUTO_CREATE)
    }

    private val connection = object: ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)
            val videoServiceBinder = service as BoundVideoService.BoundVideoServiceBinder
            videoServiceBinder.getService().setVideoView(binding.videoViewContainer)

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            messenger = null // Not ideal
        }
    }
}