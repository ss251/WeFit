package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Diet(
    val id: String,
    val nutrient_data: List<Nutrients>
): Parcelable