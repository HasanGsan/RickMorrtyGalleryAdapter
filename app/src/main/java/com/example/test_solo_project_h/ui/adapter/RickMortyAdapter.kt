package com.example.test_solo_project_h.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_solo_project_h.databinding.ListItemBinding
import com.example.test_solo_project_h.domain.model.RickMortyModel

class RickMortyAdapter : RecyclerView.Adapter<RickMortyAdapter.myViewHolder>(){
    inner class myViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<RickMortyModel>(){
        override fun areItemsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean = oldItem == newItem

    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: List<RickMortyModel>) = differ.submitList(list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder = myViewHolder(
        ListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),parent, false
        )
    )


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            imagePost.load(item.image)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}