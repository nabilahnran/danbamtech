package com.danbamtech.healthcare.ui.dokter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.danbamtech.healthcare.R
import com.danbamtech.healthcare.data.RiwayatKonsul
import com.danbamtech.healthcare.databinding.ActivityInputKeluhanPasienBinding
import com.danbamtech.healthcare.ui.dokter.adapter.HistoryKeluhanAdapter
import com.google.firebase.database.*

class InputKeluhanPasien : AppCompatActivity(){

    private lateinit var riwayatList: MutableList<RiwayatKonsul>
    private lateinit var ref: DatabaseReference

    private lateinit var binding : ActivityInputKeluhanPasienBinding


    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAMA = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputKeluhanPasienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Masukkan Riwayat Konsultasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
                    val adapter = HistoryKeluhanAdapter(this@InputKeluhanPasien,
                        R.layout.item_list_riwayat_konsultasi, riwayatList)
                    binding.lvRiwayatKonsul.adapter = adapter

                    println("Output "+ binding.lvRiwayatKonsul)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


        binding.btnSimpan.setOnClickListener {
            simpanData()

        }
    }

    private fun simpanData() {

        val id = intent.getStringExtra(EXTRA_ID)

        val diagnosis = binding.diagnosis.text.toString().trim()
        val obat = binding.obat.text.toString().trim()
        val waktu = binding.waktu.text.toString().trim()
        val detail = binding.detailRiwayat.text.toString().trim()
        val iddokter = binding.idDokter.text.toString().trim()

        if (diagnosis.isEmpty()){
            binding.diagnosis.error = "data harus diisi"
        }
        if (obat.isEmpty()){
            binding.obat.error = "data harus diisi"
        }
        if (waktu.isEmpty()){
            binding.waktu.error = "data harus diisi"
        }
        if (detail.isEmpty()){
            binding.detailRiwayat.error = "data harus diisi"
        }
        if (iddokter.isEmpty()){
            binding.idDokter.error = "data harus diisi"
        }

        val riwayatId = ref.push().key

        val riwayat =
            RiwayatKonsul(detail, diagnosis, iddokter, riwayatId!!, obat, id!!, waktu)

        ref.child(riwayatId).setValue(riwayat).addOnCompleteListener {
            Toast.makeText(applicationContext, "Riwayat konsultasi pasien berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}