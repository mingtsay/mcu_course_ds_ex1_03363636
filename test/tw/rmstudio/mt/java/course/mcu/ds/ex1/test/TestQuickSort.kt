package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.QuickSort

class TestQuickSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = QuickSort().sortResult(randomNumbers).sortedNumbers
}
