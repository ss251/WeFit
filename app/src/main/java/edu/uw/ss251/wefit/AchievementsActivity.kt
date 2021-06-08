package edu.uw.ss251.wefit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.ss251.wefit.data.AchievementProvider
import edu.uw.ss251.wefit.databinding.ActivityAchievementsBinding

fun navigateToAchievementsActivity(context: Context) {
    val intent = Intent(context, AchievementsActivity::class.java)
    val bundle = Bundle()
    intent.putExtras(bundle)
    context.startActivity(intent)
}

class AchievementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            val achievements = AchievementProvider.listOfAchievements
            val adapter = AchievementListAdapter(achievements)
            rvAchievements.adapter = adapter
        }

        // adds back button to activity and sets title
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        actionBar.title = "Achievements"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}