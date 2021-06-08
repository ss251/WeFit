package edu.uw.ss251.wefit

import android.content.Context
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
    private val activityAdapter = ActivityListAdapter(selectedActivites)
    private val dietAdapter = DietListAdapter(selectedDiets)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCalendarBinding.inflate(inflater)

        with(binding) {

            rvActivities.adapter = activityAdapter
            rvDiets.adapter = dietAdapter
            cvCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
                onDateChange(year, month, dayOfMonth)
            }
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val today = Calendar.getInstance()
        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        val day = today.get(Calendar.DAY_OF_MONTH)
        val todayDate = "$month/" +
                "$day/" +
                "$year"
        val activities = application.activityMap[todayDate]
        val diets = application.dietMap[todayDate]
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
        Log.i("fdsa", application.dietMap.toString())
        Log.i("fdsa", todayDate)
        Log.i("fdsa", "$diets, $selectedDiets")
        Log.i("fdsa", application.dietMap[todayDate].toString())
        activityAdapter.updateActivities(selectedActivites)
        dietAdapter.updateDiets(selectedDiets)
    }


    fun onDateChange(year : Int,
         month: Int,
         dayOfMonth: Int) {
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
        Log.i("fdsa", application.dietMap.toString())
        Log.i("fdsa", date)
        Log.i("fdsa", "$diets, $selectedDiets")
        Log.i("fdsa", application.dietMap[date].toString())

        activityAdapter.updateActivities(selectedActivites)
        dietAdapter.updateDiets(selectedDiets)
    }
}

