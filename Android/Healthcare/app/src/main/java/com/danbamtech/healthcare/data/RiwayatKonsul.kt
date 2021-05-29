package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class RiwayatKonsul(
    var id: String,
    var id_pasien: String,
    var id_dokter: String,
    var riwayat_penyakit: String,
    var detail_riwayat_penyakit: String,
    var waktu_konsul: String
) {
    constructor(): this ("","","","","","")
}