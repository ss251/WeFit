package edu.uw.ss251.wefit.onboard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import edu.uw.ss251.wefit.R
import edu.uw.ss251.wefit.WeFitApplication
import edu.uw.ss251.wefit.databinding.ActivityWeightBinding
import edu.uw.ss251.wefit.navigateToMainActivity


fun navigateToGetWeightActivity(context: Context) = with(context) {
    // take the person object send it to

    val intent = Intent(this, WeightActivity::class.java) // declare to launch PersonDetailActi
    // we don't need to create a bundle here because we are storing song at the application level
    startActivity(intent)
}

const val LB_TO_KG_CONVERSION_CONSTANT = 0.453592
class WeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightBinding
    private val WeFitApp by lazy {applicationContext as WeFitApplication }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        binding = ActivityWeightBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding){
            getWeight.addTextChangedListener(onTextChanged = { _: CharSequence?, _: Int, _: Int, _: Int ->
                WeFitApp.weight = (getWeight.text.toString().toDouble() * LB_TO_KG_CONVERSION_CONSTANT)  // cast to double
                Log.i("LEBRON WEIGHT", WeFitApp.weight.toString())
            })
            next.setOnClickListener {
                navigateToMainActivity(this@WeightActivity)
            }

            prev.setOnClickListener {
                navigateToGetNameActivity(this@WeightActivity)
            }
        }
    }
}