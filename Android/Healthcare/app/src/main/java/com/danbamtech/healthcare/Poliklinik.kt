package com.danbamtech.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.danbamtech.healthcare.databinding.ActivityPoliklinikBinding

class Poliklinik : AppCompatActivity() {
    private val SPLASH_TIME: Long = 5000
    private lateinit var binding: ActivityPoliklinikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPoliklinikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this, PoliActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}