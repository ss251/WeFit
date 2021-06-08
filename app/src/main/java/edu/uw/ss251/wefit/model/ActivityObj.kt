package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ActivityObj (
    val activity: String,
    val duration: Int,
    val calories: Int
    ):Parcelable