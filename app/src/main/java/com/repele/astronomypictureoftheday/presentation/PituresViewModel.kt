package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.repele.astronomypictureoftheday.data.NasaPictureSource
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import com.repele.astronomypictureoftheday.domain.use_case.GetPageOfPictures
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PituresViewModel @Inject constructor(
    private val repository: NasaPictureRepository,
) : ViewModel() {

    val pictures = Pager(PagingConfig(pageSize = 10)) {
        NasaPictureSource(repository)
    }.flow.cachedIn(viewModelScope)
}