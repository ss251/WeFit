package edu.uw.ss251.wefit

import android.app.Application
import android.widget.Toast
import edu.uw.ss251.wefit.model.ActivityObj
import edu.uw.ss251.wefit.model.DietObj
import edu.uw.ss251.wefit.repository.DataRepository

class WeFitApplication: Application() {

	lateinit var dataRepository: DataRepository
	var dietMap : MutableMap<String, DietObj> = mutableMapOf()
	var activityMap : MutableMap<String, ActivityObj> = mutableMapOf()

	override fun onCreate() {
		super.onCreate()

		dataRepository = DataRepository()

		Toast.makeText(this, "Dotify loaded", Toast.LENGTH_SHORT).show()
	}
}
