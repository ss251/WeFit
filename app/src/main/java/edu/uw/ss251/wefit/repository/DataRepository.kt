package edu.uw.ss251.wefit.repository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.uw.ss251.wefit.DietLogFragment
import edu.uw.ss251.wefit.R
import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding
import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding.inflate
import edu.uw.ss251.wefit.model.Diet
import edu.uw.ss251.wefit.model.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

class DataRepository {

    private val nutritionService = Retrofit.Builder()
        .baseUrl("https://nutrition-api.esha.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NutritionService::class.java)

    var dietLog = "donut"

    suspend fun getNutrition(): Food = nutritionService.getNutrition(dietLog)

    suspend fun getFood(): Diet = nutritionService.getFood(nutritionService.getNutrition(dietLog).items[0].id)

}


interface NutritionService {

    @Headers(
        "Ocp-Apim-Subscription-Key: 01d6d4552e504c9e865f2f3c459ae196"
    )
    @GET("foods?count=1&start=0&spell=true&")
    suspend fun getNutrition(@Query("query") query: String): Food

    @Headers(
        "Ocp-Apim-Subscription-Key: 01d6d4552e504c9e865f2f3c459ae196"
    )
    @GET("food/{uri}")
    suspend fun getFood(@Path("uri") uri: String): Diet

}

