package edu.uw.ss251.wefit

import android.app.Application

class WeFitApplication: Application() {
	override fun onCreate() {
		super.onCreate()
	}

	var userName = "Guest"
	var weight = 0.0 // kgs

}
