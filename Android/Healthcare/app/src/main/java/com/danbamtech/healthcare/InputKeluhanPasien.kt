package com.danbamtech.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.danbamtech.healthcare.data.RiwayatKonsul
import com.google.firebase.database.*

class InputKeluhanPasien : AppCompatActivity(){

    private lateinit var tvDiagnosis: EditText
    private lateinit var tvObat: EditText
    private lateinit var tvWaktu: EditText
    private lateinit var tvDetail: EditText
    private lateinit var tvIdDokter : EditText
    private lateinit var btnSimpan: Button
    private lateinit var btnRiwayat: Button
    private lateinit var riwayatList: MutableList<RiwayatKonsul>
    private lateinit var ref: DatabaseReference
    private lateinit var listView: ListView


    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAMA = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_keluhan_pasien)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Masukkan Riwayat Konsultasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        tvDiagnosis = findViewById(R.id.diagnosis)
        tvObat = findViewById(R.id.obat)
        tvWaktu = findViewById(R.id.waktu)
        tvDetail = findViewById(R.id.detail_riwayat)
        tvIdDokter = findViewById(R.id.id_dokter)
        btnSimpan = findViewById(R.id.btn_simpan)
        btnRiwayat = findViewById(R.id.btn_lihat_riwayat)
        listView = findViewById(R.id.lv_riwayat_konsul)

        val id = intent.getStringExtra(EXTRA_ID)
        val nama = intent.getStringArrayExtra(EXTRA_NAMA)

        riwayatList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("riwayat_konsul").child(id!!)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    riwayatList.clear()
                    for (a in snapshot.children) {
                        val riwayat = a.getValue(RiwayatKonsul::class.java)
                        if (riwayat != null) {
                            riwayatList.add(riwayat)
                        }
                    }
                    val adapter = HistoryKeluhanAdapter(this@InputKeluhanPasien, R.layout.item_list_riwayat_konsultasi, riwayatList)
                    listView.adapter = adapter

                    println("Output "+ listView)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


        btnSimpan.setOnClickListener {
            simpanData()

        }
//        btnRiwayat.setOnClickListener {
//            val riwayat = riwayatList.get(0)
//            val intent = Intent(this, HistoryKeluhanPasien::class.java)
//            intent.putExtra(HistoryKeluhanPasien.EXTRA_IDRIWAYAT, riwayat.id)
//            intent.putExtra(HistoryKeluhanPasien.EXTRA_NAMARIWAYAT, riwayat.pasien_id)
//            startActivity(intent)
//        }
    }

    private fun simpanData() {
        val diagnosis = tvDiagnosis.text.toString().trim()
        val obat = tvObat.text.toString().trim()
        val waktu = tvWaktu.text.toString().trim()
        val detail = tvDetail.text.toString().trim()
        val iddokter = tvIdDokter.text.toString().trim()

        if (diagnosis.isEmpty()){
            tvDiagnosis.error = "data harus diisi"
        }
        if (obat.isEmpty()){
            tvObat.error = "data harus diisi"
        }
        if (waktu.isEmpty()){
            tvWaktu.error = "data harus diisi"
        }
        if (detail.isEmpty()){
            tvDetail.error = "data harus diisi"
        }
        if (iddokter.isEmpty()){
            tvIdDokter.error = "data harus diisi"
        }

        val riwayatId = ref.push().key

        val riwayat =
            RiwayatKonsul(detail, diagnosis, iddokter, riwayatId!!, obat, riwayatId!!, waktu)

        ref.child(riwayatId).setValue(riwayat).addOnCompleteListener {
            Toast.makeText(applicationContext, "Riwayat konsultasi pasien berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}