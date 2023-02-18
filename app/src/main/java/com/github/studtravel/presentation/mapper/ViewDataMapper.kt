package com.github.studtravel.presentation.mapper

import com.github.studtravel.datasource.remote.model.DataRangeDto
import com.github.studtravel.datasource.remote.model.DormitoryDto
import com.github.studtravel.datasource.remote.model.DormitoryInfoDto
import com.github.studtravel.datasource.remote.model.RoomDto
import com.github.studtravel.domain.model.DataRange
import com.github.studtravel.domain.model.Dormitory
import com.github.studtravel.domain.model.DormitoryInfo
import com.github.studtravel.domain.model.Room
import com.github.studtravel.presentation.model.DataRangeViewData
import com.github.studtravel.presentation.model.DormitoryInfoViewData
import com.github.studtravel.presentation.model.DormitoryViewData
import com.github.studtravel.presentation.model.RoomViewData

fun DataRange.toViewData() = DataRangeViewData(
    from = from,
    to = to
)

fun Room.toViewData(): RoomViewData = RoomViewData(
    id = id,
    universityId = universityId,
    timestamp = timestamp,
    dataRange = dataRange?.toViewData(),
    amount = amount,
    price = price,
    type = type,
    photos = photos
)


fun DormitoryInfo.toViewData(): DormitoryInfoViewData = DormitoryInfoViewData(
    name = name,
    city = city,
    longitude = longitude,
    latitude = latitude,
    maxDays = maxDays,
    street = street,
    houseNumber = houseNumber,
    photos = photos
)

fun Dormitory.toViewData(): DormitoryViewData = DormitoryViewData(
    id = id,
    universityId = universityId,
    timestamp = timestamp,
    rooms = rooms.map { it.toViewData() },
    info = info?.toViewData()
)
