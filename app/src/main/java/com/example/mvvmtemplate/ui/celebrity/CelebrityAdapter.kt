package com.example.mvvmtemplate.ui.celebrity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtemplate.base.BaseAdapter
import com.example.mvvmtemplate.base.BaseHolder
import com.example.mvvmtemplate.databinding.RowCelebLayoutBinding
import com.example.mvvmtemplate.model.Celebrity

class CelebrityAdapter(private val onClickAction: ((Celebrity) -> Unit)) : BaseAdapter<Celebrity, RowCelebLayoutBinding, CelebrityHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CelebrityHolder {
        return CelebrityHolder(
            RowCelebLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickAction
        )
    }
}

class CelebrityHolder(
    viewBinding: RowCelebLayoutBinding,
    private val onClickAction: (Celebrity) -> Unit
) : BaseHolder<Celebrity, RowCelebLayoutBinding>(viewBinding) {
    override fun bind(binding: RowCelebLayoutBinding, item: Celebrity?) {
        item?.let { celebrity ->
            binding.apply {
                text.text = celebrity.nameSurname
                text.setOnClickListener {
                    onClickAction.invoke(item)
                }
            }
        } ?: return
    }
}