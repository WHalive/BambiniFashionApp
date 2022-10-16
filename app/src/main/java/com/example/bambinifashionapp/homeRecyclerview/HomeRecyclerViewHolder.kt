package com.example.bambinifashionapp.homeRecyclerview//package com.example.bambinifashionapp.recyclerview

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.bambinifashionapp.data.ContentType
import com.example.bambinifashionapp.databinding.BannerItemViewBinding
import com.example.bambinifashionapp.databinding.FeaturedItemViewBinding
import com.example.bambinifashionapp.databinding.QuadroItemViewBinding

sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class BannerViewHolder(private val binding: BannerItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(bannerImage: ContentType.BannerType) {
            binding.bannerImage.load(bannerImage.data.image.src)
        }
    }

    class FeaturedViewHolder(private val binding: FeaturedItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(
            featuredImage: ContentType.FeaturedCategoriesType
        ) {
            binding.featuredImage0.load(featuredImage.data.categories[0].image.src)
            binding.featuredImage0Text.text = featuredImage.data.categories[0].title
            binding.featuredImage1.load(featuredImage.data.categories[1].image.src)
            binding.featuredImage1Text.text = featuredImage.data.categories[1].title
            binding.featuredImage2.load(featuredImage.data.categories[2].image.src)
            binding.featuredImage2Text.text = featuredImage.data.categories[2].title
            binding.featuredImage3.load(featuredImage.data.categories[3].image.src)
            binding.featuredImage3Text.text = featuredImage.data.categories[3].title

        }
    }

    class QuadroViewHolder(private val binding: QuadroItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(
            quadroItem: ContentType.QuadroType

        ) {
            binding.mainQuadroImage.load(quadroItem.data.image.src)
            binding.quadroTitle.text = quadroItem.data.title
            binding.quadroImage0.setBackgroundColor(quadroItem.data.categories[0].backgroundColor.toColorInt())
            binding.quadroImage0.load(quadroItem.data.categories[0].image.src)
            binding.quadroImage0Text.text = quadroItem.data.categories[0].title
            binding.quadroImage1.setBackgroundColor(quadroItem.data.categories[1].backgroundColor.toColorInt())
            binding.quadroImage1.load(quadroItem.data.categories[1].image.src)
            binding.quadroImage1Text.text = quadroItem.data.categories[1].title
            binding.quadroImage2.setBackgroundColor(quadroItem.data.categories[2].backgroundColor.toColorInt())
            binding.quadroImage2.load(quadroItem.data.categories[2].image.src)
            binding.quadroImage2Text.text = quadroItem.data.categories[2].title
            binding.quadroImage3.setBackgroundColor(quadroItem.data.categories[3].backgroundColor.toColorInt())
            binding.quadroImage3.load(quadroItem.data.categories[3].image.src)
            binding.quadroImage3Text.text = quadroItem.data.categories[3].title

        }
    }
}
