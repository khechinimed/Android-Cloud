package fr.khechini.khechini.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.khechini.khechini.R
import fr.khechini.khechini.databinding.ItemCustomRecyclerBinding
import fr.khechini.khechini.databinding.ItemCustomRecyclerHeaderBinding
import fr.khechini.khechini.model.MyObjectForRecyclerView
import fr.khechini.khechini.model.ObjectDataHeaderSample
import fr.khechini.khechini.model.ObjectDataSample
import java.lang.RuntimeException

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {

    override fun areItemsTheSame(
        oldItem: MyObjectForRecyclerView,
        newItem: MyObjectForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MyObjectForRecyclerView,
        newItem: MyObjectForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }
}

class AndroidVersionAdapter(
    private val onItemClick: (quoteUi: ObjectDataSample, view: View) -> Unit,
) : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                AndroidVersionViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }
            MyItemType.HEADER.type -> {
                AndroidVersionHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as ObjectDataSample)
            MyItemType.HEADER.type -> (holder as AndroidVersionHeaderViewHolder).bind(
                getItem(
                    position
                ) as ObjectDataHeaderSample
            )
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ObjectDataSample -> MyItemType.ROW.type
            is ObjectDataHeaderSample -> MyItemType.HEADER.type
        }
    }
}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding,
    onItemClick: (objectDataSample: ObjectDataSample, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: ObjectDataSample

    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }

    fun bind(objectDataSample: ObjectDataSample) {
        ui = objectDataSample
        binding.itemRecyclerViewVersionName.text = objectDataSample.versionName
        binding.itemRecyclerViewVersionCode.text = "${objectDataSample.versionCode}"
        Glide.with(itemView.context)
            .load(objectDataSample.versionImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemRecyclerViewVersionImage)
    }
}

class AndroidVersionHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: ObjectDataHeaderSample) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1)
}