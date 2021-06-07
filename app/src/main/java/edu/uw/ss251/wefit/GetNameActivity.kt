package edu.uw.ss251.wefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.ss251.wefit.databinding.ActivityWeightBinding

class GetNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightBinding
    private val WeFitApp by lazy { applicationContext as WeFitApplication }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_name)
    }
}