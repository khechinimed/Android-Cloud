package fr.khechini.khechini.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.khechini.khechini.databinding.ActivityRecyclerViewBinding
import fr.khechini.khechini.model.MyObjectForRecyclerView
import fr.khechini.khechini.model.ObjectDataHeaderSample
import fr.khechini.khechini.model.ObjectDataSample

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the instance of adapter
        adapter = AndroidVersionAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }

    private fun onItemClick(objectDataSample: ObjectDataSample, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.versionName, Toast.LENGTH_LONG).show()
    }

    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("Amrabet", 5),
            ObjectDataSample("Hakim Ziyech", 6),
            ObjectDataSample("Achraf Hakimi", 7),
            ObjectDataSample("Travis Scott", 8),
            ObjectDataSample("Mohamed Salah", 9),
            ObjectDataSample("Andrew Tate", 10),
            ObjectDataSample("I Show Speed", 11),
            ObjectDataSample("Ousmane Dembele", 12)
        ).groupBy {
            // Split in 2 list, modulo and not
            it.versionCode % 2 == 0
        }.forEach { (isModulo, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(ObjectDataHeaderSample("World cup champion : $isModulo"))
            result.addAll(items)
        }
        return result
    }
}
