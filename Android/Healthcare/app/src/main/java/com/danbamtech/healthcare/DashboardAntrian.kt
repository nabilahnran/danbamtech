package com.danbamtech.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.danbamtech.healthcare.data.Antrian
import com.google.firebase.database.*

class DashboardAntrian : AppCompatActivity() {

    private lateinit var ref: DatabaseReference
    private lateinit var antrianList : MutableList<Antrian>
    private lateinit var listData : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_antrian)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Antrian Poli"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ref = FirebaseDatabase.getInstance().getReference("antrian")

        listData = findViewById(R.id.lv_hasil)
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
                    val adapter = DashboardDokterAdapter(this@DashboardAntrian, R.layout.item_list_antriandokter, antrianList)
                    listData.adapter = adapter

                    println("Output : " +antrianList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}