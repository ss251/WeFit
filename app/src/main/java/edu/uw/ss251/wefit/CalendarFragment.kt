package edu.uw.ss251.wefit

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.ss251.wefit.databinding.FragmentCalendarBinding
import java.util.*

val activitiesMap = mutableMapOf("6/5/2021" to mutableListOf(Activity("fdsa")))

private var selectedActivites: MutableList<Activity> = mutableListOf()
private var selectedDiets: MutableList<Diet> = mutableListOf()

class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCalendarBinding.inflate(inflater)

        with(binding) {
            val activityAdapter = ActivityListAdapter(selectedActivites)
            val dietAdapter = DietListAdapter(selectedDiets)
            rvActivities.adapter = activityAdapter
            cvCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val actualMonth = month + 1
                val lmao = "$actualMonth/$dayOfMonth/$year"
                val activities = activitiesMap[lmao]
                if(activities == null) {
                    selectedActivites = mutableListOf()
                } else {
                    selectedActivites = activities
                }
                activityAdapter.updateActivities(selectedActivites)
            }
        }
        return binding.root
    }
}

data class Activity(val name: String)
data class Diet(val name: String)