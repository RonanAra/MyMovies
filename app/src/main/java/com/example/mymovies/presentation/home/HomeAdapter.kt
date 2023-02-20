package com.example.mymovies.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovies.databinding.ItemListHorizontalMoviesBinding
import com.example.mymovies.domain.entity.MovieListModel
import com.example.mymovies.utils.getFullImageUrl
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    var list: List<MovieListModel> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListHorizontalMoviesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolder(private val binding: ItemListHorizontalMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieListModel: MovieListModel) = binding.run {

            Glide
                .with(itemView.context)
                .load(movieListModel.imageUrl.getFullImageUrl())
                .into(ivMoviePoster)
        }
    }
}