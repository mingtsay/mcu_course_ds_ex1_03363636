package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.QuickSort;

public class TestQuickSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new QuickSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
