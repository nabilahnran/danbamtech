package com.danbamtech.healthcare.ui.dokter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.danbamtech.healthcare.R
import com.danbamtech.healthcare.data.Antrian

class DashboardDokterAdapter(
    val antrianContext: Context,
    val layoutResId: Int,
    val antrianList: List<Antrian>
) : ArrayAdapter<Antrian>(antrianContext, layoutResId, antrianList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(antrianContext)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val id: TextView = view.findViewById(R.id.id_antrian)
        val id_pasien: TextView = view.findViewById(R.id.id_pasien)

        val antrian = antrianList[position]


        id.text = "Antrian ke : " + antrian.id
        id_pasien.text = "Pasien id : "+antrian.pasien_id

        return view
    }
}