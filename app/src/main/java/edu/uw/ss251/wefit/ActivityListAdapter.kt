package edu.uw.ss251.wefit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ss251.wefit.databinding.ItemActivityBinding
import edu.uw.ss251.wefit.model.ActivityObj

class ActivityListAdapter(private var listOfActivities: List<ActivityObj>): RecyclerView.Adapter<ActivityListAdapter.ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context))
        return ActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfActivities.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = listOfActivities[position]

        // Setting each item view
        with(holder.binding) {
            tvName.text = activity.activity
            tvCalories.text = "${activity.calories} calories burned"
            tvDuration.text = "${activity.duration} mins"
        }
    }

    fun updateActivities(newList: List<ActivityObj>) {
        this.listOfActivities = newList
        notifyDataSetChanged()
    }
    class ActivityViewHolder(val binding: ItemActivityBinding): RecyclerView.ViewHolder(binding.root)

}