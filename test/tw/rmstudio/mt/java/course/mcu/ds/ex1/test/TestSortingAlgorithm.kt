package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import org.junit.Assert
import org.junit.Test
import java.util.*

abstract class TestSortingAlgorithm {
    internal abstract fun sort(randomNumbers: IntArray): IntArray

    @Test
    fun testSorting() {
        val randomNumbers = intArrayOf(8, 62, 56, 44, 13, 53, 83, 40, 18, 21, 79, 71, 66, 26, 51, 47, 78, 58, 84, 61, 2, 27, 36, 48, 35, 88, 1, 23, 83, 59, 51, 95, 12, 78, 3, 5, 78, 59, 39, 88, 53, 44, 76, 70, 9, 4, 25, 94, 80, 55, 94, 30, 73, 13, 94, 74, 32, 11, 7, 69, 42, 24, 5, 6)
        val sortedNumbers = intArrayOf(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 11, 12, 13, 13, 18, 21, 23, 24, 25, 26, 27, 30, 32, 35, 36, 39, 40, 42, 44, 44, 47, 48, 51, 51, 53, 53, 55, 56, 58, 59, 59, 61, 62, 66, 69, 70, 71, 73, 74, 76, 78, 78, 78, 79, 80, 83, 83, 84, 88, 88, 94, 94, 94, 95)
        val sortedResult = sort(randomNumbers)
        Assert.assertArrayEquals(Arrays.toString(sortedResult), sortedNumbers, sortedResult)
    }
}
