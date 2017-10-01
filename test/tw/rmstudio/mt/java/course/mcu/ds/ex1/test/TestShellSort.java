package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.ShellSort;

public class TestShellSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new ShellSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
