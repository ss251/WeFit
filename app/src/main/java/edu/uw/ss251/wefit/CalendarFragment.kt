package edu.uw.ss251.wefit

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import edu.uw.ss251.wefit.databinding.FragmentCalendarBinding
import edu.uw.ss251.wefit.model.Exercise
import edu.uw.ss251.wefit.model.DietObj
import java.util.*


class CalendarFragment : Fragment() {
    private var selectedActivites: MutableList<Exercise> = mutableListOf()
    private var selectedDiets: MutableList<DietObj> = mutableListOf()
    private val application by lazy { context?.applicationContext as WeFitApplication}

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
                onDateChange(year, month, dayOfMonth, activityAdapter, dietAdapter)
            }
        }
        return binding.root
    }

    fun onDateChange(year : Int,
         month: Int,
         dayOfMonth: Int,
         activityAdapter: ActivityListAdapter,
         dietAdapter: DietListAdapter) {
        val date = "$month/$dayOfMonth/$year"
        val activities = application.activityMap[date]
        val diets = application.dietMap[date]
        if(activities == null) {
            selectedActivites = mutableListOf()
        } else {
            selectedActivites = activities
        }
        if(diets == null) {
            selectedDiets = mutableListOf()
        } else {
            selectedDiets = diets
        }
        activityAdapter.updateActivities(selectedActivites)
        dietAdapter.updateDiets(selectedDiets)
    }
}

