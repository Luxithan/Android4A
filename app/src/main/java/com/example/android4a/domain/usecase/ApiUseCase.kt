package com.example.android4a.domain.usecase

import com.example.android4a.data.local.models.Card
import com.example.android4a.data.repository.ApiRepository

class ApiUseCase(
    private val apiRepository: ApiRepository
) {
     fun getApi(): List<Card>? {
        return apiRepository.makeApiCall()
    }
}