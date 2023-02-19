package com.github.studtravel.presentation.screen.main_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.studtravel.databinding.FragmentMainPagerBinding
import com.github.studtravel.presentation.activity.MainActivity
import com.github.studtravel.presentation.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainTabFragment : Fragment() {
    private var _binding: FragmentMainPagerBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPagerBinding.inflate(layoutInflater)

        binding.viewPager.adapter = TabAdapter(this)
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                RECYCLER_POSITION -> "СПИСОК"
                MAP_POSITION -> "КАРТА"
                else -> error("Wrong position: $position")
            }
        }.attach()

        (requireActivity() as MainActivity).showNavBottom()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class TabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = TABS_COUNT

        override fun createFragment(position: Int): Fragment =
            when (position) {
                RECYCLER_POSITION -> MainScreenFragment.createInstance()
                MAP_POSITION -> MapFindFragment.createInstance()
                else -> error("Wrong position: $position")
            }
    }

    companion object {
        private const val TABS_COUNT = 2
        private const val RECYCLER_POSITION = 0
        private const val MAP_POSITION = 1
    }
}
