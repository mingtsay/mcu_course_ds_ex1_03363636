package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class QuickSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;
    private int conditionCounter, swapCounter;

    private int[] quickSort(int[] randomNumbers) {
        int swapTempNumber, length = randomNumbers.length;
        if (length < 2) return randomNumbers;
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, length);

        int pivotIndex = 0;
        for (int i = 1; i < length; ++i) {
            ++conditionCounter;
            if (sortedNumbers[i] < sortedNumbers[0]) {
                ++pivotIndex;
                ++swapCounter;
                swapTempNumber = sortedNumbers[pivotIndex];
                sortedNumbers[pivotIndex] = sortedNumbers[i];
                sortedNumbers[i] = swapTempNumber;
            }
        }

        ++swapCounter;
        swapTempNumber = sortedNumbers[pivotIndex];
        sortedNumbers[pivotIndex] = sortedNumbers[0];
        sortedNumbers[0] = swapTempNumber;

        int[] partialSortedNumbers;
        if (pivotIndex > 1) {
            partialSortedNumbers = quickSort(Arrays.copyOfRange(sortedNumbers, 0, pivotIndex));
            System.arraycopy(partialSortedNumbers, 0, sortedNumbers, 0, partialSortedNumbers.length);
        }
        if (pivotIndex + 1 < length - 1) {
            partialSortedNumbers = quickSort(Arrays.copyOfRange(sortedNumbers, pivotIndex + 1, length));
            System.arraycopy(partialSortedNumbers, 0, sortedNumbers, pivotIndex + 1, partialSortedNumbers.length);
        }

        return sortedNumbers;
    }

    @Override
    int[] sort(int[] randomNumbers) {
        conditionCounter = 0;
        swapCounter = 0;

        randomNumbers = quickSort(randomNumbers);

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return randomNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Quick Sort";
    }

    @Override
    int getConditionCount() {
        return lastConditionCount;
    }

    @Override
    public int getSwapCount() {
        return lastSwapCount;
    }
}
