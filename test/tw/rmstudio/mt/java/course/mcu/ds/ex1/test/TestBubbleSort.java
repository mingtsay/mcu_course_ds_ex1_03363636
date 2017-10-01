package tw.rmstudio.mt.java.course.mcu.ds.ex1.test;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.BubbleSort;

public class TestBubbleSort extends TestSortingAlgorithm {
    @Override
    int[] sort(int[] randomNumbers) {
        return new BubbleSort().sortResult(randomNumbers).getSortedNumbers();
    }
}
