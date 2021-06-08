package edu.uw.ss251.wefit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ss251.wefit.databinding.ItemAchievementBinding
import edu.uw.ss251.wefit.model.Achievement

class AchievementListAdapter(private var listOfAchievements: List<Achievement>): RecyclerView.Adapter<AchievementListAdapter.AchievementViewHolder>() {
    class AchievementViewHolder(val binding: ItemAchievementBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val binding = ItemAchievementBinding.inflate(LayoutInflater.from(parent.context))
        return AchievementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        val achievement = listOfAchievements[position]
        with(holder.binding) {
            tvAchievement.text = achievement.title
            if(achievement.complete) {
                itemAchievement.visibility = View.VISIBLE
            }
        }

    }

    override fun getItemCount(): Int = listOfAchievements.size

}
