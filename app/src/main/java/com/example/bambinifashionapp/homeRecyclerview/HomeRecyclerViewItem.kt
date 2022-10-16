package com.example.bambinifashionapp.homeRecyclerview

import com.example.bambinifashionapp.data.ContentType
import com.example.bambinifashionapp.data.Image

sealed class HomeRecyclerViewItem {

    data class Banner(

        val bannerImage: ContentType.BannerType.BannerData = ContentType.BannerType.BannerData(
            Image(
                ""
            )
        )

    ) : HomeRecyclerViewItem()

    data class Featured(

        val featuredImage: ContentType.FeaturedCategoriesType.FeaturedCategoriesData = ContentType.FeaturedCategoriesType.FeaturedCategoriesData(
            listOf()
        ),


        ) : HomeRecyclerViewItem()

    data class Quadro(
        val Quadro: ContentType.QuadroType = ContentType.QuadroType(
            "", ContentType.QuadroType.QuadroData("", Image(), listOf())
        ),


        ) : HomeRecyclerViewItem()
}
