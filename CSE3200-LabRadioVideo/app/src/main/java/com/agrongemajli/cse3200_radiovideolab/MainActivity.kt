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
    private lateinit var vidService: BoundVideoService
    private var mBoundVideo: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startRadioServiceButton.setOnClickListener {
            Log.i("AGR", "Clicked Button to start stuff")
            startService(Intent(this, RadioService::class.java))
            vidService.playVideo()

        }
        binding.stopRadioServiceButton.setOnClickListener {
            stopService(Intent(this, RadioService::class.java))
            vidService.pauseVideo()
        }

    }

    override fun onStart() {
        super.onStart()
        bindService(Intent(this, BoundVideoService::class.java), connection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBoundVideo = false

    }

    private val connection = object: ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            val videoServiceBinder = service as BoundVideoService.BoundVideoServiceBinder
            vidService = videoServiceBinder.getService()
            vidService.setSurfaceHolder(binding.vidSurfView.holder)
            mBoundVideo = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mBoundVideo = false
        }
    }
}