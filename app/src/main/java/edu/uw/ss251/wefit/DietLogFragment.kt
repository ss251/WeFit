package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import edu.uw.ss251.wefit.WeFitApplication

import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding
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
                val food = dataRepository.getNutrition()
                binding.food.text = "Food: " + food.query

                val items = dataRepository.getNutrition().items[0].toString()
                // val item = dataRepository.getFood(items)
            }
        }

        return binding.root
    }
}