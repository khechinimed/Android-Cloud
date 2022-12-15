package fr.khechini.khechini.yourFeature.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import fr.khechini.khechini.R
import fr.khechini.khechini.databinding.ActivityResourceBinding

class ResourceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resourceIntegerText.text = resources.getInteger(R.integer.number_of_columns).toString()
        binding.resourceBooleanText.text = resources.getBoolean(R.bool.flag).toString()
        binding.resourceStringText.text = resources.getString(R.string.random_string)
        binding.resourceStringText.setBackgroundColor(ContextCompat.getColor(this, R.color.background_of_something))
    }
}