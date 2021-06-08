package edu.uw.ss251.wefit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import org.json.JSONObject
import java.util.*

@Parcelize
data class Food(
    val query: String,
    val items: List<@RawValue JSONObject>
):Parcelable
