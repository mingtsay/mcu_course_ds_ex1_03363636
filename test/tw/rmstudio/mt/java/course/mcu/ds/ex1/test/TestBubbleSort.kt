package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.BubbleSort

class TestBubbleSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = BubbleSort().sortResult(randomNumbers).sortedNumbers
}
