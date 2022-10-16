package com.example.bambinifashionapp.homeRecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bambinifashionapp.R
import com.example.bambinifashionapp.data.ContentType
import com.example.bambinifashionapp.data.ProlineItem
import com.example.bambinifashionapp.databinding.BannerItemViewBinding
import com.example.bambinifashionapp.databinding.FeaturedItemViewBinding
import com.example.bambinifashionapp.databinding.QuadroItemViewBinding

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    var items = listOf<ContentType>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder{
        return when (viewType) {
            R.layout.banner_item_view -> HomeRecyclerViewHolder.BannerViewHolder (
                BannerItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.featured_item_view -> HomeRecyclerViewHolder.FeaturedViewHolder (
                FeaturedItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                    )

            R.layout.quadro_item_view -> HomeRecyclerViewHolder.QuadroViewHolder (
                QuadroItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                    )
            else -> throw IllegalArgumentException(" Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {

        when (holder) {
            is HomeRecyclerViewHolder.BannerViewHolder -> holder.bind(items[position] as ContentType.BannerType)
            is HomeRecyclerViewHolder.FeaturedViewHolder -> holder.bind(items[position] as ContentType.FeaturedCategoriesType)
            is HomeRecyclerViewHolder.QuadroViewHolder -> holder.bind(items[position] as ContentType.QuadroType)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ContentType.BannerType -> R.layout.banner_item_view
            is ContentType.FeaturedCategoriesType -> R.layout.featured_item_view
            is ContentType.QuadroType-> R.layout.quadro_item_view
            else -> throw IllegalStateException()
        }
    }
}