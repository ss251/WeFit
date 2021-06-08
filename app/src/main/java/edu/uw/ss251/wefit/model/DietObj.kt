package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DietObj (
    val food: String,
    val calories: Int,
): Parcelable