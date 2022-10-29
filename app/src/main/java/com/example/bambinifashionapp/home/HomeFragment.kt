package com.example.bambinifashionapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bambinifashionapp.databinding.FragmentHomeBinding
import com.example.bambinifashionapp.homeRecyclerview.HomeRecyclerViewAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    //    private val viewModel: BambiniViewModel by viewModels()
    private val promotionAdapter by lazy { HomeViewPagerAdapter() }
    private val homeRecyclerViewAdapter by lazy { HomeRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.homeViewPager.adapter = promotionAdapter
        binding.landingRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.landingRecyclerView.adapter = homeRecyclerViewAdapter
//        binding.homeViewPager.isUserInputEnabled = false

        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            promotionAdapter.setProlineItems(promotions)
        }
        viewModel.landing.observe(viewLifecycleOwner) { landing ->
            homeRecyclerViewAdapter.items = landing.content
//            Log.d ("homeRecyclerViewAdapter", "items${homeRecyclerViewAdapter.items}")
//            Log.d("landing.content","${landing.content}")
        }
        return binding.root
    }
}
//        lifecycleScope.launchWhenResumed {
//            viewModel.landing.observe(viewLifecycleOwner) { landing ->
//                landing.content.forEach { type ->
//                    when (type) {
//                        is ContentType.BannerType -> binding.bannerImage.load(type.data.image.src)
//                    }
//                }
//            }
//        }