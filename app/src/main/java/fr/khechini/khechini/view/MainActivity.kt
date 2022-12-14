package fr.khechini.khechini.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.khechini.khechini.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainButtonActivityIntent.setOnClickListener {
            goToActivityIntent()
        }

        binding.mainButtonRecyclerView.setOnClickListener { goToRecyclerView() }

        binding.mainButtonActivityStrings.setOnClickListener { goToString() }
    }

    private fun goToActivityIntent() {
        startActivity(Intent(this, FirstActivity::class.java))
    }

    private fun goToRecyclerView() {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }

    private fun goToString() {
        startActivity(Intent(this, StringsActivity::class.java))
    }
}


