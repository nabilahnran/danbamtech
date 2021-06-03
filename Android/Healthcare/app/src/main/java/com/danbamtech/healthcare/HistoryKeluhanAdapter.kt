package com.danbamtech.healthcare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.danbamtech.healthcare.data.RiwayatKonsul

class HistoryKeluhanAdapter(
    val riwayatConext: Context,
    val layoutResId: Int,
    val riwayatList: List<RiwayatKonsul>
) : ArrayAdapter<RiwayatKonsul>(riwayatConext, layoutResId, riwayatList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(riwayatConext)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val id_pasien: TextView = view.findViewById(R.id.id_pasien)
        val id_dokter: TextView = view.findViewById(R.id.tv_id_dokter)
        val riwayat: TextView = view.findViewById(R.id.tv_diagnosis)
        val detail_riwayat: TextView = view.findViewById(R.id.tv_detail_riwayat)
        val obat: TextView = view.findViewById(R.id.tv_obat)
        val waktu: TextView = view.findViewById(R.id.tv_waktu_konsul)

        val riwayatkonsul = riwayatList[position]
        id_pasien.text = riwayatkonsul.id
        id_dokter.text = riwayatkonsul.dokter_id
        riwayat.text = riwayatkonsul.diagnosis
        detail_riwayat.text = riwayatkonsul.detail_riwayat_penyakit
        obat.text = riwayatkonsul.obat
        waktu.text = riwayatkonsul.waktu_konsul

        return view



    }
}