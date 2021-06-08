package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nutrients(
    val nutrient: String,
    val value: Number,
): Parcelable