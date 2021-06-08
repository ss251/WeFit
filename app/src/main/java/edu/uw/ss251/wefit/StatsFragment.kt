package edu.uw.ss251.wefit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

            val statsList = listOf("Calories burned: 1", "Miles run: 1", "Days since join: 1")
            val listItems = arrayOfNulls<String>(statsList.size)
            for (i in statsList.indices) {
                val stat = statsList[i]
                listItems[i] = stat
            }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItems)
            lvStats.adapter = adapter


        }

        return binding.root
    }
}