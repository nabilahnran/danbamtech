package com.danbamtech.healthcare.ui.dokter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.danbamtech.healthcare.ui.dokter.adapter.DashboardDokterAdapter
import com.danbamtech.healthcare.R
import com.danbamtech.healthcare.data.Antrian
import com.danbamtech.healthcare.databinding.ActivityDashboardDokterBinding
import com.google.firebase.database.*

class DashboardDokter : AppCompatActivity(), View.OnClickListener {

    private lateinit var ref: DatabaseReference
    private lateinit var antrianList : MutableList<Antrian>

    private lateinit var binding: ActivityDashboardDokterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardDokterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Antrian Poli"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ref = FirebaseDatabase.getInstance().getReference("antrian")

        val listData = binding.lvHasil
        antrianList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    antrianList.clear()
                    for (a in snapshot.children){
                        val antrian = a.getValue(Antrian::class.java)
                        if (antrian != null){
                            antrianList.add(antrian)
                        }
                    }
                    val adapter = DashboardDokterAdapter(this@DashboardDokter, R.layout.item_list_antriandokter, antrianList)
                    listData.adapter = adapter

                    println("Output : " +antrianList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        //list data
        listData.setOnItemClickListener { parent, view, position, id ->
            val antrian = antrianList.get(position)
            val intent = Intent(this@DashboardDokter, InputKeluhanPasien::class.java)
            intent.putExtra(InputKeluhanPasien.EXTRA_ID, antrian.pasien_id)
            intent.putExtra(InputKeluhanPasien.EXTRA_NAMA, antrian.id)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}