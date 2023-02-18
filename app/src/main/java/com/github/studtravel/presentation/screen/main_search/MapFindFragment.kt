package com.github.studtravel.presentation.screen.main_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.studtravel.databinding.MapFindFragmentBinding
import com.github.studtravel.presentation.viewmodel.MainViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFindFragment : Fragment() {
    private var _binding: MapFindFragmentBinding? = null

    private val binding get() = _binding!!

    private val mapView get() = binding.mapView

    private val viewModel: MainViewModel by activityViewModels()

    private val mapReady = OnMapReadyCallback {
        val ss = 1
        val rr = ss
        //            viewModel.dormitories.observe(viewLifecycleOwner) { dormitories ->
//                val coordinates = dormitories.map { dormitory ->
//                    Pair(dormitory.info?.latitude, dormitory.info?.longitude)
//                }.filter {
//                    it.first != null && it.second != null
//                }.map { it as Pair<Double, Double> }
//                val markerOptions = coordinates.map {it ->
//                    MarkerOptions().apply {
//                        position(LatLng(it.first, it.second))
//                    }
//                }
//                markerOptions.forEach {
//                    map.addMarker(it)
//                }
//            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MapFindFragmentBinding.inflate(layoutInflater)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(mapReady)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    companion object {
        fun createInstance(): MapFindFragment = MapFindFragment()
    }
}
