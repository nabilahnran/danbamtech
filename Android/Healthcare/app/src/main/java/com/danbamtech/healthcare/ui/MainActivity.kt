package com.danbamtech.healthcare.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danbamtech.healthcare.databinding.ActivityMainBinding
import com.danbamtech.healthcare.ui.dokter.LoginDokter
import com.danbamtech.healthcare.ui.pasien.ScanQr


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
            startActivity(Intent(this, LoginDokter::class.java))
        }

    }
}