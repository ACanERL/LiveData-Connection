package com.example.livedata_internetconnect

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.livedata_internetconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val checkConnection by lazy { CheckConnection(application) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.apply {
            checkConnection.observe(this@MainActivity){
                if (it) {
                    imgStatus.setImageResource(R.drawable.baseline_wifi_24)
                    imgStatus.setColorFilter(
                        ContextCompat.getColor(this@MainActivity,R.color.connect),
                        PorterDuff.Mode.MULTIPLY)
                    tvStatus.text="Connected ! :)"
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.connect))

                } else {
                    imgStatus.setImageResource(R.drawable.baseline_wifi_off_24)
                    imgStatus.setColorFilter(
                        ContextCompat.getColor(this@MainActivity,R.color.disConnect),
                        PorterDuff.Mode.MULTIPLY)
                    tvStatus.text="DisConnected ! :("
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.disConnect))

                }
            }

      }
    }
}