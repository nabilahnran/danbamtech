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

        val id_riwayat: TextView = view.findViewById(R.id.id_riwayat)
        val id_pasien: TextView = view.findViewById(R.id.id_pasien)
        val id_dokter: TextView = view.findViewById(R.id.id_dokter)
        val riwayat: TextView = view.findViewById(R.id.riwayat_penyakit)
        val detail_riwayat: TextView = view.findViewById(R.id.detail_riwayat)
        val waktu: TextView = view.findViewById(R.id.waktu)

        val anggota = riwayatList[position]

        id_riwayat.text = "Id riwayat : " + anggota.id
        id_pasien.text = "Id pasien : " + anggota.id_pasien
        id_dokter.text = "Id dokter : " + anggota.id_dokter
        riwayat.text = "Riwayat : " + anggota.riwayat_penyakit
        detail_riwayat.text = "Detail riwayat : " + anggota.detail_riwayat_penyakit
        waktu.text = "Waktu : " + anggota.waktu_konsul

        return view
    }
}