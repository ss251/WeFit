package edu.uw.ss251.wefit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ss251.wefit.databinding.ItemActivityBinding

class DietListAdapter(private var listOfDiet: List<Diet>): RecyclerView.Adapter<DietListAdapter.ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context))
        return ActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfDiet.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = listOfDiet[position]

        // Setting each item view
        with(holder.binding) {
            tvName.text = activity.name
        }
    }

    fun updateDiets(newList: List<Diet>) {
        this.listOfDiet = newList
        notifyDataSetChanged()
    }
    class ActivityViewHolder(val binding: ItemActivityBinding): RecyclerView.ViewHolder(binding.root)

}