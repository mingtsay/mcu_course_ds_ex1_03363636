package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.InsertionSort;

public class TestInsertionSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new InsertionSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
