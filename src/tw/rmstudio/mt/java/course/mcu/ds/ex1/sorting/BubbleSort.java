package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class BubbleSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;

    @Override
    int[] sort(int[] randomNumbers) {
        int conditionCounter = 0, swapCounter = 0;
        int length = randomNumbers.length;
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, length);

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length - i - 1; ++j) {
                ++conditionCounter;
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    ++swapCounter;
                    int swapTempNumber = sortedNumbers[j];
                    sortedNumbers[j] = sortedNumbers[j + 1];
                    sortedNumbers[j + 1] = swapTempNumber;
                }
            }
        }

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return sortedNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
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
