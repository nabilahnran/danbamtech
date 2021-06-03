package com.danbamtech.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.danbamtech.healthcare.data.RiwayatKonsul
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HistoryKeluhanPasien : AppCompatActivity() {

    private lateinit var ref: DatabaseReference
    private lateinit var listView: ListView
//    private lateinit var idPasien : TextView
//    private lateinit var idDokter : TextView
//    private lateinit var diagnosis : TextView
//    private lateinit var detailRiwayat : TextView
//    private lateinit var obat : TextView
//    private lateinit var waktuKonsul : TextView
    private lateinit var detilRiwayat: MutableList<RiwayatKonsul>

    private lateinit var userID: String

//    private lateinit var ref : DatabaseReference
//    private lateinit var riwayatList : MutableList<RiwayatKonsul>
//    private lateinit var listData : ListView
//


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_IDRIWAYAT = "extra_id"
        const val EXTRA_NAMARIWAYAT = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_keluhan_pasien)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Riwayat Konsultasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.lv_hasil)
//        idPasien = findViewById(R.id.id_pasien)
//        idDokter = findViewById(R.id.tv_id_dokter)
//        diagnosis = findViewById(R.id.tv_diagnosis)
//        detailRiwayat = findViewById(R.id.tv_detail_riwayat)
//        obat = findViewById(R.id.tv_obat)
//        waktuKonsul = findViewById(R.id.tv_waktu_konsul)

        val id = intent.getStringExtra(EXTRA_IDRIWAYAT)
        val nama = intent.getStringArrayExtra(EXTRA_NAMARIWAYAT)

        detilRiwayat = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("riwayat_konsul")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    detilRiwayat.clear()
                    for (a in snapshot.children) {
                        val detil = a.getValue(RiwayatKonsul::class.java)
                        if (detil != null) {
                            detilRiwayat.add(detil)
                        }
                    }
                    val adapter = HistoryKeluhanAdapter(
                        this@HistoryKeluhanPasien,
                        R.layout.item_list_riwayat_konsultasi,
                        detilRiwayat
                    )
                    listView.adapter = adapter

                    println("Data berhasil dipanggil")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}