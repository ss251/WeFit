package edu.uw.ss251.wefit

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.ss251.wefit.databinding.FragmentAddExerciseBinding
import edu.uw.ss251.wefit.databinding.FragmentGoalsBinding

class AddExerciseFragment : Fragment() {

    var userWeight = 0.0
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val myApp = context.applicationContext as WeFitApplication
        userWeight = myApp.weight
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddExerciseBinding.inflate(inflater)

        with(binding) {

        }
        return binding.root
    }

    fun calcCalories(duration: Int, intensity: Int): Double {
        return duration * (intensity * userWeight)/200
    }
}