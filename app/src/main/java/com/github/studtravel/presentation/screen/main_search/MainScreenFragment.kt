package com.github.studtravel.presentation.screen.main_search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.studtravel.R
import com.github.studtravel.databinding.FragmentMainBinding
import com.github.studtravel.presentation.viewmodel.MainViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    private val layoutManager: LinearLayoutManager by lazy {
        object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.domitoryRecycler.setItemViewCacheSize(300)
        viewModel.getAllDormitories()
        binding.chipGroup.addView(createTagChip(requireContext(), "Меньшая цена"))
        binding.chipGroup.addView(createTagChip(requireContext(), "Большая цена"))
        binding.chipGroup.addView(createTagChip(requireContext(), "Дальняя поездка"))
        binding.chipGroup.addView(createTagChip(requireContext(), "Поездка вблизи"))
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createTagChip(context: Context, chipName: String): Chip {
        return Chip(context).apply {
            width = 30
            text = chipName
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setChipBackgroundColorResource(R.color.primary)
            isCloseIconVisible = false
            isCheckable = true
            setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    companion object {
        fun createInstance(): MainScreenFragment = MainScreenFragment()
    }
}
