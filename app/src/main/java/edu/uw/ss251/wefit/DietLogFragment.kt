package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import edu.uw.ss251.wefit.WeFitApplication
import android.util.Log

import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding
import edu.uw.ss251.wefit.model.DietObj
import edu.uw.ss251.wefit.model.Nutrients
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class DietLogFragment : Fragment() {

    private val application by lazy { context?.applicationContext as WeFitApplication }
    private val dataRepository by lazy {application.dataRepository }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDietLogBinding.inflate(inflater)
        val dietMap = application.dietMap
        with(binding) {
                addDiet.setOnClickListener {

                    binding.dietText.text = dietText.text
                    // dataRepository.dietLog = dietText.text.toString()
                    dataRepository.dietLog = dietText.text.toString()

                    lifecycleScope.launch {
                        runCatching {
                            // val food = dataRepository.getNutrition()
                            binding.food.text = "Food: " + dietText.text


                            val items = dataRepository.getNutrition()
                            val item = dataRepository.getFood().nutrient_data.last().value

                            calories.text = "Calories: " + item
                            val today = Calendar.getInstance()
                            val year = today.get(Calendar.YEAR)
                            val month = today.get(Calendar.MONTH)
                            val day = today.get(Calendar.DAY_OF_MONTH)
                            val todayDate = "$month/" +
                                    "$day/" +
                                    "$year"
                            Log.i("fdsa", todayDate)
                            val dietToAdd = DietObj(dietText.text.toString(), item.toInt())
                            if(dietMap[todayDate] == null) {
                                dietMap[todayDate] = mutableListOf(dietToAdd)
                            } else {
                                dietMap[todayDate]?.add(dietToAdd)
                            }
                        }.onFailure { Toast.makeText(activity, "Please wait one minute before adding another item.", Toast.LENGTH_SHORT).show() }
                    }
                    // food.text = dietText.text
            }
        }

        return binding.root
    }
}