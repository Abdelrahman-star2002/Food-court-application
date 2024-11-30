package com.example.foody

import android.content.Context
import android.media.AudioManager
import android.net.rtp.AudioCodec
import android.net.rtp.AudioGroup
import android.net.rtp.AudioStream
import android.net.rtp.RtpStream
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.net.InetAddress
import java.net.UnknownHostException

class callActivity : AppCompatActivity() {

    private var audioGroup: AudioGroup? = null
    private var audioStream: AudioStream? = null
    private var onCall: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.voip)

        onCall = false



        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        findViewById<Button>(R.id.buttonConnect).setOnClickListener {
            val remoteAddress = findViewById<EditText>(R.id.editTextIp).text.toString()
            val remotePort = findViewById<EditText>(R.id.editTextPort).text.toString()

            try {
                if (!onCall) {
                    initializeAudio()
                    connectToRemote(remoteAddress, remotePort)
                    onCall = true
                } else {
                    Toast.makeText(this, "Already Connected", Toast.LENGTH_SHORT).show()
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            } catch (e: UnknownHostException) {
                e.printStackTrace()
            }
        }




    }


    private fun initializeAudio() {
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        audioManager.mode = AudioManager.MODE_IN_COMMUNICATION

        audioGroup = AudioGroup()
        audioGroup?.mode = AudioGroup.MODE_NORMAL

        audioStream = AudioStream(InetAddress.getByAddress(getLocalIPAddress()))
        val localPort = audioStream!!.localPort
        audioStream?.setCodec(AudioCodec.PCMU)
        audioStream?.mode = RtpStream.MODE_NORMAL

        findViewById<TextView>(R.id.textViewLocalInfo).text = "Local Port: $localPort"
    }


    private fun connectToRemote(remoteAddress: String, remotePort: String) {
        try {
            audioStream?.associate(InetAddress.getByName(remoteAddress), Integer.parseInt(remotePort))
            audioStream?.join(audioGroup)
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        }
    }

    private fun intToByteArray(ipAddress: Int): ByteArray {
        val byteArr = ByteArray(4)
        byteArr[0] = (ipAddress and 0xFF).toByte()
        byteArr[1] = (ipAddress shr 8 and 0xFF).toByte()
        byteArr[2] = (ipAddress shr 16 and 0xFF).toByte()
        byteArr[3] = (ipAddress shr 24 and 0xFF).toByte()
        return byteArr
    }

    private fun getLocalIPAddress(): ByteArray {
        val wm = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val ipAddress = wm.connectionInfo.ipAddress
        val inetAddress = InetAddress.getByAddress(intToByteArray(ipAddress))
        return inetAddress.address
    }

    override fun onDestroy() {
        super.onDestroy()
        if (onCall) {

            audioStream?.release()
            onCall = false
        }
    }
}
