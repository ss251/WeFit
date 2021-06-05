package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.ss251.wefit.databinding.FragmentAddExerciseBinding
import edu.uw.ss251.wefit.databinding.FragmentGoalsBinding

class AddExerciseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddExerciseBinding.inflate(inflater)

        return binding.root
    }
}

