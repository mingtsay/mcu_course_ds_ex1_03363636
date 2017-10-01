package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.MergeSort;

public class TestMergeSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new MergeSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
