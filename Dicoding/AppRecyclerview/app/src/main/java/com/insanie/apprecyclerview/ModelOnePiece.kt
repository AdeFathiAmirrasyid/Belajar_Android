package com.insanie.apprecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ModelOnePiece(
    val data_name: String = "",
    val data_desc: String = "",
    val data_image: Int   = 0,
    val data_time: String = ""
):Parcelable

