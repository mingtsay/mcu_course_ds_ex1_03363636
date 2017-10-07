package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.InsertionSort

class TestInsertionSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = InsertionSort().sortResult(randomNumbers).sortedNumbers
}
