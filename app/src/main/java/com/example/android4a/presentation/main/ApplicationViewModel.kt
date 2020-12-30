package com.example.android4a.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.data.local.models.Card
import com.example.android4a.domain.usecase.ApiUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ApplicationViewModel(
): ViewModel() {

    fun onStart(view: ApplicationActivity, apiUseCase: ApiUseCase?) {
        viewModelScope.launch(Dispatchers.IO) {
            val cardList: List<Card>? = apiUseCase?.getApi()
            view.showList(cardList)
        }
    }

}