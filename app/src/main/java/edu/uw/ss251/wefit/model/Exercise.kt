package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(
    val name: String,
    val duration: Int,
    val intensity: Int // low: 3, med: 5, high: 7
): Parcelable