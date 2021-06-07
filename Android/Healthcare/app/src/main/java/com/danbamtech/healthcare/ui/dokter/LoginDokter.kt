package com.danbamtech.healthcare.ui.dokter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danbamtech.healthcare.databinding.ActivityLoginDokterBinding

class LoginDokter : AppCompatActivity() {

    private lateinit var binding: ActivityLoginDokterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDokterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.username.text.toString().equals("dokter") && binding.password.text.toString().equals("dokter")){
                val intent = Intent(this, DashboardDokter::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Username atau password anda salah", Toast.LENGTH_SHORT).show()
            }

        }
//
//        if (user == "dokter"){
//
//                binding.btnLogin.setOnClickListener {
//                    val intent = Intent(this, DashboardDokter::class.java)
//                    startActivity(intent)
//                }
//
//        }

    }
}