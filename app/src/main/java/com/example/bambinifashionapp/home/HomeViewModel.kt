package com.example.bambinifashionapp.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bambinifashionapp.data.Content
import com.example.bambinifashionapp.data.ContentType
import com.example.bambinifashionapp.data.ProlineItem
import com.example.bambinifashionapp.homeRecyclerview.HomeRecyclerViewHolder
import com.example.bambinifashionapp.homeRecyclerview.HomeRecyclerViewItem
import com.example.bambinifashionapp.internet.FashionApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _promotions = MutableLiveData<List<ProlineItem>>()
    val promotions: LiveData<List<ProlineItem>> = _promotions

    private val _landing = MutableLiveData<Content>()
    val landing: LiveData<Content> = _landing


    init {
        getAllItems()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getAllItems() {
        viewModelScope.launch {
            try {
                _promotions.value =
                    FashionApi.retrofitService. getPromotion().user.proLine.center.items
//                Log.d("HomeViewModel", "getAllItems: ${promotions.value}")
                _landing.value = FashionApi.retrofitService.getHomeScreen().page
//                Log.d("HomeViewModel", "getAllItems: ${landing.value}")
            } catch (e: Exception) {
                Log.e("HomeViewModel", e.message.orEmpty())
            }
        }
    }
}