package edu.uw.ss251.wefit

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import edu.uw.ss251.wefit.databinding.FragmentAddExerciseBinding
import edu.uw.ss251.wefit.model.Exercise
import java.util.*

const val INTENSITY = 5

class AddExerciseFragment : Fragment() {

    private var userWeight = 0.0
    lateinit var currMap: MutableMap<String, MutableList<Exercise>>
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val myApp = context.applicationContext as WeFitApplication
        userWeight = myApp.weight
        currMap = myApp.activityMap
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddExerciseBinding.inflate(inflater)
        with(binding) {
            var duration = "0"
            var exerciseName = ""
            var calcedCaloriesBurned = 0

            caloriesBurned.text = calcedCaloriesBurned.toString()

            editActivityDuration.addTextChangedListener{
                if(editActivityDuration.text.toString() != ""){
                    duration = editActivityDuration.text.toString()
                    calcedCaloriesBurned = calcCalories(duration.toInt(), INTENSITY)
                    Log.i("LEBRON DURATION", duration)
                    Log.i("LEBRON CAL", calcedCaloriesBurned.toString())
                    caloriesBurned.text = calcedCaloriesBurned.toString()
                }
            }

            editActivityName.addTextChangedListener {
                exerciseName = editActivityName.text.toString()
                calcedCaloriesBurned = calcCalories(duration.toInt(), INTENSITY)
                Log.i("LEBRON NAME", duration)
                Log.i("LEBRON NAME CAL", calcedCaloriesBurned.toString())
                caloriesBurned.text = calcedCaloriesBurned.toString()
            }

            add.setOnClickListener {
                val activityName = editActivityName.text.toString()
                val duration = editActivityDuration.text.toString().toInt()
                calcedCaloriesBurned = calcCalories(duration, INTENSITY)
                var date = Calendar.getInstance();
                var dateString = date.get(Calendar.MONTH).toString() + "/" + date.get(Calendar.DAY_OF_MONTH).toString() + "/" + date.get(Calendar.YEAR).toString()
                val exerciseToAdd = Exercise(
                    activityName,
                    duration,
                    calcedCaloriesBurned
                )
                if (currMap.get(dateString) == null) {
                    currMap[dateString] =
                        mutableListOf(exerciseToAdd)
                } else {
                    currMap[dateString]?.add(exerciseToAdd)
                }
                Log.i("fdsa", exerciseToAdd.toString())
                Toast.makeText(activity, "Activity Succesfully Logged", Toast.LENGTH_SHORT).show()
                editActivityDuration.setText("0")
                editActivityName.text.clear()
                calcedCaloriesBurned = 0
            }
        }
        return binding.root
    }


    fun calcCalories(duration: Int, intensity: Int): Int {
        return (duration * (intensity * userWeight) /200).toInt()
    }

}
