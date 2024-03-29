package edu.uw.ss251.wefit

import android.app.Application
import android.widget.Toast
import edu.uw.ss251.wefit.model.DietObj
import edu.uw.ss251.wefit.model.Exercise
import edu.uw.ss251.wefit.repository.DataRepository

class WeFitApplication: Application() {

	lateinit var dataRepository: DataRepository
	var dietMap : MutableMap<String, MutableList<DietObj>> = mutableMapOf()
	var activityMap : MutableMap<String, MutableList<Exercise>> = mutableMapOf()

	override fun onCreate() {
		super.onCreate()

		dataRepository = DataRepository()

		// Toast.makeText(this, "WeFit loaded", Toast.LENGTH_SHORT).show()
	}

	var userName = "Guest"
	var weight = 0.0 // kgs


}
