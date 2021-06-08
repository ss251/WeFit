package edu.uw.ss251.wefit.onboard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import edu.uw.ss251.wefit.R
import edu.uw.ss251.wefit.WeFitApplication
import edu.uw.ss251.wefit.databinding.ActivityGetNameBinding
import edu.uw.ss251.wefit.databinding.ActivityWeightBinding


fun navigateToGetNameActivity(context: Context) = with(context) {
    // take the person object send it to

    val intent = Intent(this, GetNameActivity::class.java) // declare to launch PersonDetailActi
    // we don't need to create a bundle here because we are storing song at the application level
    startActivity(intent)
}

class GetNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetNameBinding
    private val WeFitApp by lazy { applicationContext as WeFitApplication }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_name)
        binding = ActivityGetNameBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding){
            editNameTextView.addTextChangedListener(onTextChanged = { _: CharSequence?, _: Int, _: Int, _: Int ->
                WeFitApp.userName = editNameTextView.text.toString() // cast to double
                Log.i("LEBRON WEIGHT", WeFitApp.userName.toString())
            })
            next.setOnClickListener {
                navigateToGetWeightActivity(this@GetNameActivity)
            }
        }
    }
}