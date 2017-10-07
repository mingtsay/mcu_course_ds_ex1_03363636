package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.MergeSort

class TestMergeSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = MergeSort().sortResult(randomNumbers).sortedNumbers
}
