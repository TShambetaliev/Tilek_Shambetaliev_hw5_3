package com.example.tilek_shambetaliev_hw5_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.tilek_shambetaliev_hw5_3.databinding.ItemImageBinding

class PixaAdapter(val list: ArrayList<ImageModel>) : Adapter<PixaAdapter.PixaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addImages(listImages: ArrayList<ImageModel>) {
        list.addAll(listImages)
    }

    class PixaViewHolder(var binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.ivImages.load(imageModel.largeImageURL)
        }
    }
}