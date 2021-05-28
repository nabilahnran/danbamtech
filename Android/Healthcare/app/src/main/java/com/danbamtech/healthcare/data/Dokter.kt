package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dokter(
    var id_dokter: String,
    var nama_dokter: String,
    var id_spesialis: String
) : Parcelable