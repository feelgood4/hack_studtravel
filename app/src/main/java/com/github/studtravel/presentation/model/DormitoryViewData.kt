package com.github.studtravel.presentation.model

import com.github.studtravel.BR
import com.github.studtravel.R

data class DormitoryViewData(
    override val id: String,
    val timestamp: Long,
    val universityId: String,
    val rooms: List<RoomViewData>,
    val info: DormitoryInfoViewData?,
    val minPrice: Double? = rooms.minOfOrNull { it.price }
): RecyclerViewItem{
    override val layoutId: Int
        get() = R.layout.card_dormitory

    override val variableId: Int
        get() = BR.item
}
