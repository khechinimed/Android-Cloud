package fr.khechini.khechini.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.khechini.khechini.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the xml layout to attach to this activity
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // We can get the TextView directly from it's id and interact with it
        binding.firstActivityTextViewTitle.text = "Another text from activity"
        binding.firstActivityButton.setOnClickListener {
            generateIntentAndGoTo()
        }
    }

    private fun generateIntentAndGoTo() {
        // Java style
        val intent = Intent(this, SecondActivity::class.java)
        val bundle = Bundle()
        bundle.putString("MY_KEY", "MY_VALUE")
        intent.putExtras(bundle)
        // Start activity
        startActivity(intent)


        // Kotlin style
        /*val intentKotlin = Intent(this, SecondActivity::class.java).also {
            it.putExtras(Bundle().apply {
                putString("MY_KEY", "MY_VALUE")
            })
        }
        // Start activity
        startActivity(intentKotlin)*/
    }
}