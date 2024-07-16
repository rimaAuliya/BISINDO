package com.example.isyaratku.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Populer(
    val title: String,
    val image: Int
): Parcelable
