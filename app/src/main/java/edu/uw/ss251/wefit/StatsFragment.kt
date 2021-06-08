package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.uw.ss251.wefit.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStatsBinding.inflate(inflater)
        with(binding) {
            fbGoals.setOnClickListener { navigateToAchievementsActivity(requireContext()) }
        }
        return binding.root
    }
}