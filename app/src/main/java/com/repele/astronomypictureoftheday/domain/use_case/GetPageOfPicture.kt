package com.repele.astronomypictureoftheday.domain.use_case

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import java.lang.Exception
import javax.inject.Inject

class GetPageOfPicture @Inject constructor(
    private val pictureRepository: NasaPictureRepository,
) : PagingSource<Int, PictureOfTheDay>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PictureOfTheDay> {
        return try {
            val pageIndex = params.key ?: 0
            val pictureList = pictureRepository.getPictureList(pageIndex)

            LoadResult.Page(
                data = pictureList,
                prevKey = if (pageIndex == 0) null else pageIndex - 1,
                nextKey = pageIndex + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PictureOfTheDay>): Int? {
        return state.anchorPosition
    }
}
