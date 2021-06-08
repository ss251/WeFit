package edu.uw.ss251.wefit.repository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.uw.ss251.wefit.DietLogFragment
import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding.inflate
import edu.uw.ss251.wefit.model.Diet
import edu.uw.ss251.wefit.model.Food
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

class DataRepository {

    private val nutritionService = Retrofit.Builder()
        .baseUrl("https://nutrition-api.esha.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NutritionService::class.java)
    suspend fun getNutrition(): Food = nutritionService.getNutrition()

}


interface NutritionService {

    @Headers(value = ["Ocp-Apim-Subscription-Key: 143fd3d6b67c4925b8a23629bfdf44a8"]
    )

    @GET("foods?query=donut&count=1&start=0&spell=true&")
    suspend fun getNutrition(): Food

    @GET("food/{uri}")
    suspend fun getFood(@Path("uri") uri: String): Diet


}

