package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.repele.astronomypictureoftheday.domain.use_case.GetPageOfPicture
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PituresViewModel @Inject constructor(
    private val getPageOfPictures: GetPageOfPicture,
) : ViewModel() {

    val pictures = Pager(PagingConfig(pageSize = 10)) {
        getPageOfPictures
    }.flow.cachedIn(viewModelScope)
}
