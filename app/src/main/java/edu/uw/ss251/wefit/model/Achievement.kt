package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Achievement(
    val title: String,
    val complete: Boolean

): Parcelable