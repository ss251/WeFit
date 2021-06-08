package edu.uw.ss251.wefit

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import edu.uw.ss251.wefit.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {
    private lateinit var myApp: WeFitApplication
    private lateinit var statValues: List<Int>
    private lateinit var valueAdapter: ArrayAdapter<Number>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        myApp = context.applicationContext as WeFitApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStatsBinding.inflate(inflater)
        with(binding) {
            fbGoals.setOnClickListener { navigateToAchievementsActivity(requireContext()) }

            val statTitles = listOf(
                "Calories burned: ",
                "Calories consumed: ",
                "Cumulative exercise time (min): ",
                "Total days active: ")
            val listItems = arrayOfNulls<String>(statTitles.size)
            for (i in statTitles.indices) {
                val stat = statTitles[i]
                listItems[i] = stat
            }
            val titleAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItems)
            lvStatTitle.adapter = titleAdapter

            statValues = listOf(
                74,
                260,
                30,
                1) //placeholder data
            val listValues = arrayOfNulls<Number>(statValues.size)
            for (i in statValues.indices) {
                val stat = statValues[i]
                listValues[i] = stat
            }
            valueAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listValues)
            lvStatValue.adapter = valueAdapter
        }

        return binding.root
    }

}