package com.avazpar.featureflag.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avazpar.featureflag.domain.CreditScoreFlagUseCase
import kotlinx.coroutines.flow.collect

class MainViewModel(
        private val creditScoreFlagUseCase: CreditScoreFlagUseCase
) : ViewModel() {

    private var _creditScore: MutableLiveData<Boolean> = MutableLiveData()
    val creditScore: LiveData<Boolean> = _creditScore

    fun getCreditScore() {
        viewModelScope.launch {
            creditScoreFlagUseCase.observe(Unit).collect { result ->
                _creditScore.postValue(true)
            }
        }
    }
}