package edu.uw.ss251.wefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.findNavController
import edu.uw.ss251.wefit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            fbAdd.setOnClickListener{
                navController.navigate(NavGraphDirections.actionGlobalAddExerciseFragment())
            }
            ibCalendar.setOnClickListener{
                navController.navigate(NavGraphDirections.actionGlobalCalendarFragment())
            }
            ibGoals.setOnClickListener{
                navController.navigate(NavGraphDirections.actionGlobalGoalsFragment())
            }
        }
    }
}