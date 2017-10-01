package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class SelectionSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;

    @Override
    int[] sort(int[] randomNumbers) {
        int conditionCounter = 0, swapCounter = 0;
        int length = randomNumbers.length;
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, length);

        for (int i = 0; i < length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                ++conditionCounter;
                if (sortedNumbers[minIndex] > sortedNumbers[j]) {
                    minIndex = j;
                }
            }

            ++swapCounter;
            int swapTempNumber = sortedNumbers[i];
            sortedNumbers[i] = sortedNumbers[minIndex];
            sortedNumbers[minIndex] = swapTempNumber;
        }

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return sortedNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Selection Sort";
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
