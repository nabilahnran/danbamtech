package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class RiwayatKonsul(
    var detail_riwayat_penyakit: String,
    var diagnosis: String,
    var dokter_id: String,
    var id: String,
    var obat: String,
    var pasien_id: String,
    var waktu_konsul: String
) {
    constructor(): this ("","","","","","","")
}