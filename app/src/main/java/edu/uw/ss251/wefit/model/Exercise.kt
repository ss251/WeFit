package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(
    val name: String,
    val duration: Int,
    val calories_burned: Int,
): Parcelable