package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.repele.astronomypictureoftheday.data.source.NasaPicturePaging
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PituresViewModel @Inject constructor(
    private val repository: NasaPictureRepository,
) : ViewModel() {

    val pictures = Pager(PagingConfig(pageSize = 10)) {
        NasaPicturePaging(repository)
    }.flow.cachedIn(viewModelScope)
}
