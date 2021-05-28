package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpesialisasiPoli(
    var id_spesialis: String,
    var rumahsakit_id: String,
    var namaspesialis: String
) : Parcelable
