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
            ObjectDataSample(
                "Android Lollipop",
                5,
                "https://lh3.googleusercontent.com/-rACz0MZcC3g/VcUIM6IJr5I/AAAAAAAAAB4/bnKPAnrGL1A/s400/Google-officially-released-Android-5.0-Lollipop-source-code-into-the-AOSP-Details.png"
            ),
            ObjectDataSample(
                "Android Marshmallow",
                6,
                "https://www.android-logiciels.fr/wp-content/uploads/2015/08/android-m-news.png"
            ),
            ObjectDataSample(
                "Android Nougat",
                7,
                "https://img-0.journaldunet.com/9K_wGeBu2TxODL6zOEHZWgsacKE=/1240x/smart/af8490af57424d3e923a0259002a111b/ccmcms-jdn/10336314-android-7-0-nougat-les-nouveautes-a-retenir.jpg"
            ),
            ObjectDataSample(
                "Android Oreo",
                8,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Android_Oreo_8.1_logo.svg/1200px-Android_Oreo_8.1_logo.svg.png"
            ),
            ObjectDataSample(
                "Android Pie",
                9,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Android_P_logo.svg/1200px-Android_P_logo.svg.png"
            ),
            ObjectDataSample(
                "Android-Q",
                10,
                "https://images.frandroid.com/wp-content/uploads/2018/05/android-q-developer-preview-logo.jpg"
            )
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
