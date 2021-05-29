package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Dokter(
    var id: String,
    var nama_dokter: String,
    var spesialis_id: String
) {
    constructor(): this("", "", "")
}