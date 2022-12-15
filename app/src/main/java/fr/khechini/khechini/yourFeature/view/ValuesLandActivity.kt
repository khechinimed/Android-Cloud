package fr.khechini.khechini.yourFeature.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.khechini.khechini.R
import fr.khechini.khechini.databinding.ActivityValuesBinding

class ValuesLandActivity: AppCompatActivity() {

    private lateinit var binding : ActivityValuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchValuesLand.text = getString(R.string.random_string)
        binding.switchValuesLand.isEnabled = resources.getBoolean(R.bool.flag)
    }
}