package edu.uw.ss251.wefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import edu.uw.ss251.wefit.databinding.ActivityWeightBinding

class WeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightBinding
    private val WeFitApp by lazy {applicationContext as WeFitApplication}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        binding = ActivityWeightBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding){
            getWeight.addTextChangedListener(onTextChanged = { _: CharSequence?, _: Int, _: Int, _: Int ->
                WeFitApp.weight = getWeight.text.toString().toDouble() // cast to double
                Log.i("LEBRON WEIGHT", WeFitApp.weight.toString())
            })


        }
    }
}