//package com.example.bambinifashionapp.homeV2
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.bambinifashionapp.data.Proline
//import com.example.bambinifashionapp.data.ProlineItem
//import com.example.bambinifashionapp.internet.FashionApi
//import kotlinx.coroutines.channels.ConflatedBroadcastChannel
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.launch
//
//class HomeV2ViewModel : ViewModel() {
//    private val currentIndex = MutableStateFlow(0)
//    private val _currentPromotion = MutableLiveData<ProlineItem>()
//    val currentPromotion: LiveData<ProlineItem> = _currentPromotion
//
//    private val promotionTickerFlow: StateFlow<Unit> = MutableStateFlow(Unit).asStateFlow()
//
//    init {
//        getPromotions()
//        promotionTickerFlow
//            .transformLatest<Unit, Unit> {
//                val promotion = promotions[currentIndex.value]
//                _currentPromotion.value = promotion
//                delay(promotion.duration)
//            }
//    }
//
//    private fun getPromotions() {
//        viewModelScope.launch {
//            try {
//                val promotions = FashionApi.retrofitService.getPromotion().user.proLine.center.items
//                calculateCurrentPromotion(promotions)
//            } catch (e: Exception) {
//                Log.e("HomeV2ViewModel", e.message.orEmpty())
//            }
//        }
//    }
//
//    private fun calculateCurrentPromotion(promotions: List<ProlineItem>) {
//        viewModelScope.launch {
//            promotionTickerFlow
//                .transformLatest<Unit, Unit> {
//                    val promotion = promotions[currentIndex.value]
//                    _currentPromotion.value = promotion
//                    delay(promotion.duration)
//                }
//                .collect()
//        }
//    }
//    /*
//    private fun calculateCurrentPromotion(promotions: List<ProlineItem>) {
//        if (promotions.isNotEmpty()) {
//            viewModelScope.launch {
//                val index = currentIndex.value ?: 0
//                _currentPromotion.value = promotions[index]
//                delay(_currentPromotion.value?.duration ?: 0L)
//
//            }
//        }
//    }*/
//}