package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.SelectionSort

class TestSelectionSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = SelectionSort().sortResult(randomNumbers).sortedNumbers
}
