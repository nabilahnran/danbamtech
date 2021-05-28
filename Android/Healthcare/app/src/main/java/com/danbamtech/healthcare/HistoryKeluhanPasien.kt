package com.danbamtech.healthcare

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.danbamtech.healthcare.databinding.ActivityHistoryKeluhanPasienBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class HistoryKeluhanPasien : AppCompatActivity() {
    companion object {
        private val TAG = HistoryKeluhanPasien::class.java.simpleName
    }
    private lateinit var binding: ActivityHistoryKeluhanPasienBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryKeluhanPasienBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomQuote()
    }

    private fun getRandomQuote() {
        val client = AsyncHttpClient()
        val url = "https://bigquery.googleapis.com/bigquery/v2/projects/capstone-project-313106/datasets/danbam_tech/tables/riwayat_konsul?access_token=ya29.a0AfH6SMCiWZGEBqsCYJK7xCL9WWkItjjy5kjR1_Zzh3nE5GPZFK7CHBIlH_yH_qYQCoIwAhB5PHhxagQdwynMIvm_q8a07NkoAjhoU76y3np4L62qX6n_fHXwtGwxDteihxUaE862AAomsR_KYxH_UR2TXhFx"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Jika koneksi berhasil

                val listQuote = ArrayList<String>()
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val jsonObject = JSONObject(result)

//                    for (i in 0 until jsonObject.length()) {
//                        val jsonObject = jsonArray.getJSONObject(i)
//                        val quote = jsonObject.getString("v")
//                        listQuote.add("\n$quote")
//                    }

                    val quote = jsonObject.getString("id")
                    listQuote.add("\n$quote")

                    val adapter = ArrayAdapter(this@HistoryKeluhanPasien, R.layout.simple_list_item_1, listQuote)
                    binding.listNama.adapter = adapter
                } catch (e: Exception) {
                    Toast.makeText(this@HistoryKeluhanPasien, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }

            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                // Jika koneksi gagal
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                //Toast.makeText(this@HistoryKeluhanPasien, errorMessage, Toast.LENGTH_SHORT).show()

            }
        })
    }
}