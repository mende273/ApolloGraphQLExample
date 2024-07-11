package mende273.apollographqlclientexample.data.mapper

import mende273.apollographqlclientexample.HistoriesQuery
import mende273.apollographqlclientexample.RocketsQuery
import mende273.apollographqlclientexample.domain.model.History
import mende273.apollographqlclientexample.domain.model.Rocket

fun RocketsQuery.Rocket.toDomain(): Rocket =
    Rocket(
        name = name ?: "",
        company = company ?: "",
        country = country ?: "",
        description = description ?: "",
        wikipedia = wikipedia ?: ""
    )

fun HistoriesQuery.History.toDomain(): History =
    History(
        details = details ?: "",
        title = title ?: ""
    )