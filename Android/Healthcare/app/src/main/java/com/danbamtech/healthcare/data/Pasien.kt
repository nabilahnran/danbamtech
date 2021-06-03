package com.danbamtech.healthcare.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pasien(
        var id: String,
        var jeniskelamin_pasien: String,
        var nama_pasien: String,
        var notelp_pasien: String,
        var umur_pasien: Int
) : Parcelable