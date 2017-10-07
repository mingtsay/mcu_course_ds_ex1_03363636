package tw.rmstudio.mt.java.course.mcu.ds.ex1.test

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.ShellSort

class TestShellSort : TestSortingAlgorithm() {
    override fun sort(randomNumbers: IntArray) = ShellSort().sortResult(randomNumbers).sortedNumbers
}
