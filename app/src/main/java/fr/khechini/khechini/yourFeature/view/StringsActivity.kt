package fr.khechini.khechini.yourFeature.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.khechini.khechini.R
import fr.khechini.khechini.databinding.ActivityStringsBinding

class StringsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStringsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStringsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewPluralsOne.text = resources.getQuantityString(R.plurals.found_word, 1)
        binding.textViewPluralsTwo.text = resources.getQuantityString(R.plurals.found_word, 3)

        // Define value for dynamic content in string
        binding.textViewDynamicString.text = String.format(getString(R.string.dynamic_content), "Serreau", "Jordane", 27);

        // You can mix dynamic values and plurals / single variable
        binding.textViewDynamicPlurals.text = resources.getQuantityString(R.plurals.dynamic_plurals, 4, 2);
    }
}