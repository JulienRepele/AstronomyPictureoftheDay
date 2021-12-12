package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.repele.astronomypictureoftheday.domain.use_case.GetPageOfPicture
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PituresViewModel @Inject constructor(
    private val getPageOfPictures: GetPageOfPicture,
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableSharedFlow<Boolean>()
    val error: SharedFlow<Boolean> get() = _error

    fun onLoading() {
        _loading.value = true
    }

    fun onNotLoading() {
        _loading.value = false
    }

    fun onError() {
        _error.tryEmit(true)
    }

    val pictures = Pager(PagingConfig(pageSize = 10)) {
        getPageOfPictures
    }.flow.cachedIn(viewModelScope)
}
