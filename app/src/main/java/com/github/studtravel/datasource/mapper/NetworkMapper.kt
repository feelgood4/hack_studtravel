package com.github.studtravel.datasource.mapper

import com.github.studtravel.datasource.remote.model.DataRangeDto
import com.github.studtravel.datasource.remote.model.DormitoryDto
import com.github.studtravel.datasource.remote.model.DormitoryInfoDto
import com.github.studtravel.datasource.remote.model.RoomDto
import com.github.studtravel.domain.model.DataRange
import com.github.studtravel.domain.model.Dormitory
import com.github.studtravel.domain.model.DormitoryInfo
import com.github.studtravel.domain.model.Room

fun DataRangeDto.toData() = DataRange(
    from = from,
    to = to
)

fun RoomDto.toData(): Room = Room(
    id = id,
    universityId = universityId,
    timestamp = timestamp,
    dataRange = details.dataRange?.toData(),
    amount = details.amount.toDouble(),
    price = details.price.toDouble(),
    type = details.type,
    photos = details.photos
)


fun DormitoryInfoDto.toData(): DormitoryInfo = DormitoryInfo(
    name = name,
    city = city,
    longitude = coordinates.longitude?.toDouble(),
    latitude = coordinates.latitude?.toDouble(),
    maxDays = maxDays,
    street = street,
    houseNumber = houseNumber,
    photos = photos
)

fun DormitoryDto.toData(): Dormitory = Dormitory(
    id = id,
    universityId = universityId,
    timestamp = timestamp,
    rooms = rooms.values.toList().map { it.toData() },
    info = details?.info?.toData()
)
