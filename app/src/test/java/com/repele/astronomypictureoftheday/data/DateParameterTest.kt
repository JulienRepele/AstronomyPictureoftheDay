package com.repele.astronomypictureoftheday.data

import java.util.*
import org.junit.Assert.*
import org.junit.Test


class DateParameterTest {

    private val referenceDateTimestamp = 1638995135676 // december 2021 the 8th
    private val itemsPerPage = 10
    private val fakeToday = Date(referenceDateTimestamp)

    @Test
    fun `get first page of photos`() {
        // Given
        val dateRangeParameter = DateParameter(itemsPerPage, fakeToday)
        val pageIndex = 0

        // When
        val startDateParameter = dateRangeParameter.getStartDateParameter(pageIndex)
        val getEndDateParameter = dateRangeParameter.getEndDateParameter(pageIndex)

        // Then
        assertEquals("2021-12-08", startDateParameter)
        assertEquals("2021-11-29", getEndDateParameter)
    }

    @Test
    fun `get second page of photos`() {
        // Given
        val dateRangeParameter = DateParameter(itemsPerPage, fakeToday)
        val pageIndex = 1

        // When
        val startDateParameter = dateRangeParameter.getStartDateParameter(pageIndex)
        val getEndDateParameter = dateRangeParameter.getEndDateParameter(pageIndex)

        // Then
        assertEquals("2021-11-28", startDateParameter)
        assertEquals("2021-11-19", getEndDateParameter)
    }

    @Test
    fun `get third page of photos`() {
        // Given
        val dateRangeParameter = DateParameter(itemsPerPage, fakeToday)
        val pageIndex = 2

        // When
        val startDateParameter = dateRangeParameter.getStartDateParameter(pageIndex)
        val getEndDateParameter = dateRangeParameter.getEndDateParameter(pageIndex)

        // Then
        assertEquals("2021-11-18", startDateParameter)
        assertEquals("2021-11-09", getEndDateParameter)
    }

    @Test
    fun `should not overflow after 1 year`() {
        // Given
        val dateRangeParameter = DateParameter(itemsPerPage, fakeToday)
        val pageIndex = 38

        // When
        val startDateParameter = dateRangeParameter.getStartDateParameter(pageIndex)
        val getEndDateParameter = dateRangeParameter.getEndDateParameter(pageIndex)

        // Then
        assertEquals("2020-11-23", startDateParameter)
        assertEquals("2020-11-14", getEndDateParameter)
    }
}