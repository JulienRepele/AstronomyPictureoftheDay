package com.repele.astronomypictureoftheday.data

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

/**
 * The class DateParameter should help to build query parameter for the Nasa apod API.
 *
 * The API retuns a list of PictureOfTheDay whiting the date range specified int teh parameters.
 * This class ease the usage of the API by building the date parameters according to the page index.
 * @see <a href="https://github.com/nasa/apod-api#docs-">APOD API documentation</a>
 */
class DateParameter(
    private val numberOfElementsPerPage: Int = 10,
    private val referenceDate: Date = Date(),
) {
    private val DAY_IN_MS: Long = 24 * 60 * 60 * 1000 // Should be a long to avoid Int overflow
    private val APO_API_DATE_FORMAT = "yyy-MM-dd"

    /**
     * Finds the start_date parameter date and retuns it in the Nasa APOD API format.
     * First page has the index 0
     */
    fun getStartDateParameter(pageIndex: Int): String {
        return Date(referenceDate.time - DAY_IN_MS * ((pageIndex + 1) * numberOfElementsPerPage - 1)).toNasApiFormat()
    }

    /**
     * Finds the end_date parameter date and retuns it in the Nasa APOD API format.
     * First page has the index 0
     */
    fun getEndDateParameter(pageIndex: Int): String {
        return Date(referenceDate.time - DAY_IN_MS * numberOfElementsPerPage * pageIndex).toNasApiFormat()
    }

    @SuppressLint("SimpleDateFormat")
    private fun Date.toNasApiFormat(): String {
        return SimpleDateFormat(APO_API_DATE_FORMAT).format(this)
    }
}