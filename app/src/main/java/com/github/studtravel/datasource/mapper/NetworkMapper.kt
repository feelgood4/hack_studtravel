package com.github.studtravel.datasource.mapper

import com.github.studtravel.datasource.remote.model.DataRangeDto
import com.github.studtravel.datasource.remote.model.RoomDto
import com.github.studtravel.domain.model.DataRange
import com.github.studtravel.domain.model.Room

fun DataRangeDto.toData() = DataRange(
    from = from,
    to = to
)

fun RoomDto.toData(): Room = Room(
    id = id,
    universityId = universityId,
    timestamp = timestamp,
    dataRange = details.dataRange.toData(),
    amount = details.amount.toDouble(),
    price = details.price.toDouble(),
    type = details.type,
    photos = details.photos
)

