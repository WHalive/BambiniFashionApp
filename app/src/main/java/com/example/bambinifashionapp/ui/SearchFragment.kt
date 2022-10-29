package com.example.bambinifashionapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bambinifashionapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}

/*
LANDING
curl -XGET -H 'bf-api-key: nAdCsZsfxD2wRZFL' -H 'bf-localization: AT,USD,en' 'https://babydriver-android.bambinimirror.com/m/v1/page:type=landing'

PROMO
curl -XGET -H 'bf-api-key: nAdCsZsfxD2wRZFL' -H 'bf-localization: AT,USD,en' 'https://babydriver-android.bambinimirror.com/m/v1/user:proline'

 */

