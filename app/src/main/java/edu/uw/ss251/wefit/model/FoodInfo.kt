package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodInfo(
    val id: String,
    val nutrient_data: List<Nutrients>
): Parcelable

