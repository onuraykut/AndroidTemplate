package com.example.mvvmtemplate.ui.celebrity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtemplate.databinding.RowCelebLayoutBinding
import com.example.mvvmtemplate.model.Celebrity

class CelebrityAdapter() : RecyclerView.Adapter<CelebrityAdapter.ViewHolder>() {

    private val items = mutableListOf<Celebrity>()

    class ViewHolder(val binding: RowCelebLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RowCelebLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.text.text = "sda"
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(itemList: List<Celebrity>) {
        items.clear()
        items.addAll(itemList)
        notifyDataSetChanged()
    }
}