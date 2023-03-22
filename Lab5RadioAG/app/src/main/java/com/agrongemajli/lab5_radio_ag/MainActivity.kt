package com.agrongemajli.lab5_radio_ag

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agrongemajli.lab5_radio_ag.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var stationAdapter: RadioStationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMediaPlayer()

        val stations = listOf(
            RadioStation(
                "BeachGrooves Radio",
                "https://nl.radio.net/images/broadcasts/09/ba/36350/c300.png",
                "https://stream.beachgrooves.com:9000/stream.mp3"
            ),RadioStation(
                "Radio Tanger Med",
                "http://www.radiotangermed.com/wp-content/uploads/2020/11/cropped-logo-vector-180x180.png",
                "http://radiotangermed-22.ice.infomaniak.ch/radiotangermed-22-128.mp3"
            ),
            RadioStation(
                "Radio 2",
                "https://www.0nradio.com/logos/0n-classic-rock_600x600.jpg",
                "https://0n-classicrock.radionetz.de/0n-classicrock.mp3"
            ),
            RadioStation(
                "Car Tune Radio",
                "https://cartunesradio.com/favicon.ico",
                "http://198.199.71.224:5000/cartunes.mp3"
            ),
            RadioStation(
                "KALX - UC Berkeley",
                "https://cartunesradio.com/favicon.ico",
                "http://stream.kalx.berkeley.edu:8000/kalx-128.mp3"
            ),
            RadioStation(
                "WHTA FM",
                "https://cartunesradio.com/favicon.ico",
                "https://24283.live.streamtheworld.com/WHTAFM.mp3"
            ),
            RadioStation(
                "BBC - Radio 2",
                "https://cartunesradio.com/favicon.ico",
                "http://open.live.bbc.co.uk/mediaselector/5/select/version/2.0/mediaset/http-icy-mp3-a/vpid/bbc_radio_two/format/pls.pls"
            ),
            RadioStation(
                "WHUS - UConn Radio FM",
                "https://cartunesradio.com/favicon.ico",
                "http://stream.whus.org:8000/whusfm"
            )

        )

        setupRadioStationAdapter(stations)
        setupControls()

        }

    private fun setupMediaPlayer(){
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build())
        mediaPlayer?.setOnPreparedListener {
            mediaPlayer?.start()
        }
    }

    private fun setupRadioStationAdapter(stations: List<RadioStation>) {
        stationAdapter = RadioStationAdapter(stations) { radioStation ->
            // Handle radio station click event here
            switchRadioStation(radioStation)
            Log.i("RADIO", "Clicked a new station.")
        }
        binding.stationsRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stationAdapter
        }
    }

    private fun switchRadioStation(radioStation: RadioStation) {
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("RADIO", "Released mediaplayer")
        setupMediaPlayer()
        try{
            mediaPlayer?.setDataSource(radioStation.streamUrl)
            //set default volume to seekbar at 50%
            mediaPlayer?.setVolume(binding.volumeSeekbar.progress/100.0F, binding.volumeSeekbar.progress/100.0F)
            Log.i("RADIO", "Set Data Source - "+radioStation.streamUrl)
            mediaPlayer?.prepareAsync()
            Log.i("RADIO", "prepared the radio")

        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun setupControls() {
        // Set up play/pause button and volume seekbar here
        binding.playButton.setOnClickListener{
            // Handle play button click
            mediaPlayer?.start()
        }

        binding.pauseButton.setOnClickListener{
            mediaPlayer?.pause()
        }

        binding.volumeSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                Log.i("RADIO", "Set volume to " + seekBar.progress.toString())
                mediaPlayer?.setVolume(seekBar.progress.toFloat()/100.0F, seekBar.progress.toFloat()/100.0F)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // do nothing. We only care when its changed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //  do nothing.
            }
        })

    }

    }