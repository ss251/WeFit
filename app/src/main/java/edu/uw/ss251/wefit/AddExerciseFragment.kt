package edu.uw.ss251.wefit

import android.R
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

const val INTENSITY = 5

class AddExerciseFragment : Fragment() {

    private var userWeight = 0.0
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
                editActivityDuration.setText("0")
                editActivityName.text.clear()
                calcedCaloriesBurned = 0
                Toast.makeText(activity, "Activity Succesfully Logged", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }


    fun calcCalories(duration: Int, intensity: Int): Int {
        return (duration * (intensity * userWeight) /200).toInt()
    }

}
