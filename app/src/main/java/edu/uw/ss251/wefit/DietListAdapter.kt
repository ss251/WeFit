package edu.uw.ss251.wefit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ss251.wefit.databinding.ItemActivityBinding
import edu.uw.ss251.wefit.databinding.ItemDietBinding
import edu.uw.ss251.wefit.model.DietObj

class DietListAdapter(private var listOfDiet: List<DietObj>): RecyclerView.Adapter<DietListAdapter.ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemDietBinding.inflate(LayoutInflater.from(parent.context))
        return ActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfDiet.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val diet = listOfDiet[position]

        // Setting each item view
        with(holder.binding) {
            tvName.text = diet.food
            tvCalories.text = "${diet.calories} Calories"
            tvAmount.text = "${diet.amount} ${diet.units}"
        }
    }

    fun updateDiets(newList: List<DietObj>) {
        this.listOfDiet = newList
        notifyDataSetChanged()
    }
    class ActivityViewHolder(val binding: ItemDietBinding): RecyclerView.ViewHolder(binding.root)

}