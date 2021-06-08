package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import edu.uw.ss251.wefit.WeFitApplication

import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding
import edu.uw.ss251.wefit.model.Nutrients
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DietLogFragment : Fragment() {

    private val application by lazy { context?.applicationContext as WeFitApplication }
    private val dataRepository by lazy {application.dataRepository }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDietLogBinding.inflate(inflater)

        with(binding) {



            lifecycleScope.launch {

                addDiet.setOnClickListener {
                    binding.dietText.text = dietText.text
                    dataRepository.dietLog = dietText.text.toString()

                    food.text = dietText.text
                }

                dataRepository.dietLog = dietText.text.toString()
                val food = dataRepository.getNutrition()
                binding.food.text = "Food: " + food.query


                val items = dataRepository.getNutrition()
                val item = dataRepository.getFood().nutrient_data.last().value

                calories.text = "Calories: " + item
            }
        }

        return binding.root
    }
}