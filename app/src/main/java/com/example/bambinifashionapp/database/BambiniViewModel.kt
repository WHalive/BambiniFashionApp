package com.example.bambinifashionapp.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bambinifashionapp.repository.BambiniRepository
import kotlinx.coroutines.launch

class BambiniViewModel(private val repository: BambiniRepository): ViewModel() {

    val allPromotions: LiveData<List<PromotionEntity>> = repository.allPromotions
//    init {
//       getAllItems()
//    }

//    private fun getAllItems(){
//        viewModelScope.launch {
//            try {
//                repository.refreshPromotions()
//            }catch (e:Exception){
//                e.printStackTrace()
//            }
//        }
//    }
}
