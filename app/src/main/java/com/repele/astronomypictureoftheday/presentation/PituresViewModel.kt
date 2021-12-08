package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private var pageLoaded = -1
    private val _pictures = MutableStateFlow<List<PictureOfTheDay>>(emptyList())
    val pictures = _pictures.asStateFlow()

    init {
        loadNextPage()
    }

    private fun loadNextPage() {
        viewModelScope.launch {
            val newPictures = GetPageOfPictures(repository).invoke(pageLoaded + 1)
            if (newPictures.isNotEmpty()) {
                val mergedList = mutableListOf<PictureOfTheDay>()
                mergedList.addAll(pictures.value)
                mergedList.addAll(newPictures)
                _pictures.value = mergedList
                pageLoaded++
            }
        }
    }
}