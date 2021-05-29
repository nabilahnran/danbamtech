package com.danbamtech.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.danbamtech.healthcare.data.RiwayatKonsul
import com.google.firebase.database.*

class HistoryKeluhanPasien : AppCompatActivity() {

//    private lateinit var binding: ActivityHistoryKeluhanPasienBinding
    private lateinit var ref : DatabaseReference
    private lateinit var riwayatList : MutableList<RiwayatKonsul>
    private lateinit var listData : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_keluhan_pasien)
//        binding = ActivityHistoryKeluhanPasienBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        ref = FirebaseDatabase.getInstance().getReference("riwayat_konsul")

        listData = findViewById(R.id.lv_hasil)
        riwayatList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    riwayatList.clear()
                    for (a in snapshot.children){
                        val riwayat = a.getValue(RiwayatKonsul::class.java)
                        if (riwayat != null){
                            riwayatList.add(riwayat)
                        }
                    }
                    val adapter = HistoryKeluhanAdapter(this@HistoryKeluhanPasien, R.layout.item_list_riwayat_konsultasi, riwayatList)
                    listData.adapter = adapter
//                    binding.lvHasil.adapter = adapter

                    println("Output : " +riwayatList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

//    companion object {
//        private val TAG = HistoryKeluhanPasien::class.java.simpleName
//    }
//    private lateinit var binding: ActivityHistoryKeluhanPasienBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHistoryKeluhanPasienBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        getRandomQuote()
//    }
//
//    private fun getRandomQuote() {
//        val client = AsyncHttpClient()
//        val url = "https://bigquery.googleapis.com/bigquery/v2/projects/capstone-project-313106/datasets/danbam_tech/tables/riwayat_konsul?access_token=ya29.a0AfH6SMCiWZGEBqsCYJK7xCL9WWkItjjy5kjR1_Zzh3nE5GPZFK7CHBIlH_yH_qYQCoIwAhB5PHhxagQdwynMIvm_q8a07NkoAjhoU76y3np4L62qX6n_fHXwtGwxDteihxUaE862AAomsR_KYxH_UR2TXhFx"
//        client.get(url, object : AsyncHttpResponseHandler() {
//            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
//                // Jika koneksi berhasil
//
//                val listQuote = ArrayList<String>()
//                val result = String(responseBody)
//                Log.d(TAG, result)
//                try {
//                    val jsonObject = JSONObject(result)
//
////                    for (i in 0 until jsonObject.length()) {
////                        val jsonObject = jsonArray.getJSONObject(i)
////                        val quote = jsonObject.getString("v")
////                        listQuote.add("\n$quote")
////                    }
//
//                    val quote = jsonObject.getString("id")
//                    listQuote.add("\n$quote")
//
//                    val adapter = ArrayAdapter(this@HistoryKeluhanPasien, R.layout.simple_list_item_1, listQuote)
//                    binding.listNama.adapter = adapter
//                } catch (e: Exception) {
//                    Toast.makeText(this@HistoryKeluhanPasien, e.message, Toast.LENGTH_SHORT).show()
//                    e.printStackTrace()
//                }
//
//            }
//            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
//                // Jika koneksi gagal
//                val errorMessage = when (statusCode) {
//                    401 -> "$statusCode : Bad Request"
//                    403 -> "$statusCode : Forbidden"
//                    404 -> "$statusCode : Not Found"
//                    else -> "$statusCode : ${error.message}"
//                }
//                //Toast.makeText(this@HistoryKeluhanPasien, errorMessage, Toast.LENGTH_SHORT).show()
//
//            }
//        })
//    }
}