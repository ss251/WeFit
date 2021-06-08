package edu.uw.ss251.wefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import edu.uw.ss251.wefit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            fbExercise.setOnClickListener{ navController.navigate(NavGraphDirections.actionGlobalAddExerciseFragment()) }
            fbCalendar.setOnClickListener{ navController.navigate(NavGraphDirections.actionGlobalCalendarFragment()) }
            fbStats.setOnClickListener{ navController.navigate(NavGraphDirections.actionGlobalStatsFragment()) }
            fbDiet.setOnClickListener{ navController.navigate(NavGraphDirections.actionGlobalDietLogFragment()) }
        }

    }

}