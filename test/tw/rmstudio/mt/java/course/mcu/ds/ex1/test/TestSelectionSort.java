package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.SelectionSort;

public class TestSelectionSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new SelectionSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
