package com.danbamtech.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.danbamtech.healthcare.data.Antrian
import com.danbamtech.healthcare.data.Pasien
import com.google.firebase.database.*

class KeluhanPasien : AppCompatActivity() {

    private lateinit var tvIdPasien : TextView
    private lateinit var tvNamaPasien : TextView
    private lateinit var tvUmurPasien : TextView
    private lateinit var tvJenisKelaminPasien : TextView
    private lateinit var ref : DatabaseReference
    private lateinit var pasienList : MutableList<Pasien>
    private lateinit var antrianList : MutableList<Antrian>

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAMA = "extra_nama"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keluhan_pasien)

        tvIdPasien = findViewById(R.id.id_pasien)
        tvNamaPasien = findViewById(R.id.nama_pasien)
        tvUmurPasien = findViewById(R.id.umur_pasien)
        tvJenisKelaminPasien = findViewById(R.id.jk_pasien)

        val id = intent.getStringExtra(EXTRA_ID)

        ref = FirebaseDatabase.getInstance().getReference("pasien").child(id!!)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    pasienList.clear()
                    for (a in snapshot.children){
                        val pas = a.getValue(Pasien::class.java)
                        if (pas != null){
                            pasienList.add(pas)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Data tidak bisa muncul")
            }
        })


    }
}