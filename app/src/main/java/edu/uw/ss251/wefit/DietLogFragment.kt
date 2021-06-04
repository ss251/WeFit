package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.ss251.wefit.databinding.FragmentCalendarBinding
import edu.uw.ss251.wefit.databinding.FragmentDietLogBinding

class DietLogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDietLogBinding.inflate(inflater)

        return binding.root
    }
}