package edu.uw.ss251.wefit

import android.app.Application

class WeFitApplication: Application() {
	override fun onCreate() {
		super.onCreate()
	}

	var userName = "Guest"
	var weight = 69.0 // kgs

//	var activityMap = mutableMapOf<String, List<MutableMap<String, String>>>()

}
