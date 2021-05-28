package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RiwayatKonsul (
    var id_riwayat: String,
    var id_pasien: String,
    var id_dokter: String,
    var riwayat_penyakit: String,
    var detail_riwayat_penyakit: String,
    var wakttu_konsul: String
) : Parcelable