package com.github.studtravel.presentation.screen.main_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.github.studtravel.databinding.CardDormitoryBinding
import com.github.studtravel.databinding.MapFindFragmentBinding
import com.github.studtravel.presentation.model.map.PlaceItem
import com.github.studtravel.presentation.viewmodel.MainViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.maps.android.clustering.ClusterManager
import kotlinx.coroutines.launch

class MapFindFragment : Fragment() {
    private var _binding: MapFindFragmentBinding? = null

    private val binding get() = _binding!!

    private val mapView get() = binding.mapView

    private val viewModel: MainViewModel by activityViewModels()

    private val mapReady = OnMapReadyCallback { map ->
        map.setupMap()
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

    private fun GoogleMap.setupMap() {
        viewModel.dormitories.observe(viewLifecycleOwner) { dormitories ->
            lifecycleScope.launch {
                val coordinates = dormitories.mapNotNull { dormitory ->
                    if (dormitory.info?.latitude != null && dormitory.info?.longitude != null) {
                        Pair(dormitory.id, LatLng(dormitory.info.latitude, dormitory.info.longitude))
                    } else null
                }
                val clusterManager =
                    ClusterManager<PlaceItem>(requireContext(), this@setupMap).apply {
                        val placeItems = coordinates.map {
                            val id = it.first
                            val coordinates = it.second
                            PlaceItem(id, coordinates, "0", "0")
                        }
                        addItems(placeItems)
                    }
                clusterManager.setOnClusterItemClickListener {
                    createBottomSheetDialog(it.id)
                    true
                }

                setOnCameraIdleListener(clusterManager)
                setOnMarkerClickListener(clusterManager)
            }
        }
    }

    private fun createBottomSheetDialog(id: String) {
        val dialog = BottomSheetDialog(requireContext()).apply {
            s
        }
        val binding = CardDormitoryBinding.inflate(layoutInflater)
        val item = viewModel.dormitories.value?.firstOrNull { it.id == id } ?: return
        binding.item = item
        dialog.setContentView(binding.root)
        dialog.show()
    }

    companion object {
        fun createInstance(): MapFindFragment = MapFindFragment()
    }
}
