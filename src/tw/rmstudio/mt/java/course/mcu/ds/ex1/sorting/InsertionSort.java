package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class InsertionSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;

    @Override
    int[] sort(int[] randomNumbers) {
        int conditionCounter = 0, swapCounter = 0;
        int length = randomNumbers.length;
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, length);

        for (int i = 1, j; i < length; ++i) {
            int swapTempNumber = sortedNumbers[i];
            for (j = i - 1; j >= 0; --j) {
                ++conditionCounter;
                if (sortedNumbers[j] <= swapTempNumber) break;

                ++swapCounter;
                sortedNumbers[j + 1] = sortedNumbers[j];
            }
            ++swapCounter;
            sortedNumbers[j + 1] = swapTempNumber;
        }

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return sortedNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Insertion Sort";
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
