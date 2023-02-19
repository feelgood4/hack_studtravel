package com.github.studtravel.presentation.model.map

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class PlaceItem(
    val id: String,
    private val positionParam: LatLng,
    private val titleParam: String,
    private val snippetParam: String
): ClusterItem {
    override fun getPosition(): LatLng = positionParam

    override fun getTitle(): String = titleParam

    override fun getSnippet(): String = snippetParam
}
