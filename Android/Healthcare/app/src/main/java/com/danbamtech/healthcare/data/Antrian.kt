package com.danbamtech.healthcare.data

data class Antrian(
    var id: String,
    var pasien_id: String
) {
    constructor(): this ("", "")
}
