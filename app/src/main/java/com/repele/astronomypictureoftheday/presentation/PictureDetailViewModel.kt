package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.use_case.GetPictureDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class PictureDetailViewModel @Inject constructor(
    private val getPictureDetails: GetPictureDetails,
) : ViewModel() {
    private val _pictureDetails = MutableStateFlow<PictureOfTheDay?>(null)
    val pictureDetails: StateFlow<PictureOfTheDay?> get() = _pictureDetails

    fun loadPicture(id: String) {
        val picture = getPictureDetails(id)
        _pictureDetails.value = picture
    }
}