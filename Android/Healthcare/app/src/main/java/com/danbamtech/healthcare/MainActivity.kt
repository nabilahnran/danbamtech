package com.danbamtech.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.danbamtech.healthcare.databinding.ActivityAmbilAntrianBinding
import com.danbamtech.healthcare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMonitorantrian.setOnClickListener {
            startActivity(Intent(this, DashboardAntrian::class.java))
        }

        binding.btnMenupasien.setOnClickListener {
            startActivity(Intent(this, ScanQr::class.java))
        }

        binding.btnMenudokter.setOnClickListener {
            startActivity(Intent(this, DashboardDokter::class.java))
        }
    }
}