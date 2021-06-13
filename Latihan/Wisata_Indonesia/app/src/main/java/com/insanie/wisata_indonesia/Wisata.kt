package com.insanie.wisata_indonesia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Wisata (
    var dataName    : String = "",
    var dataDesc    : String = " ",
    var dataImage   : Int = 0
    ) : Parcelable