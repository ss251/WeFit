package edu.uw.ss251.wefit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.findNavController
import edu.uw.ss251.wefit.databinding.ActivityMainBinding
import edu.uw.ss251.wefit.onboard.WeightActivity

fun navigateToMainActivity(context: Context) = with(context) {
    // take the person object send it to

    val intent = Intent(this, MainActivity::class.java) // declare to launch PersonDetailActi
    // we don't need to create a bundle here because we are storing song at the application level
    startActivity(intent)
}

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