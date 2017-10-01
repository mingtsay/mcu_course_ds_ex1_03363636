package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class ShellSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;

    @Override
    int[] sort(int[] randomNumbers) {
        int conditionCounter = 0, swapCounter = 0;
        int length = randomNumbers.length;
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, length);

        int swapTempNumber, gapSize = 1;

        while (gapSize < length / 3) gapSize = gapSize * 3 + 1;

        for (; gapSize > 0; gapSize /= 3) {
            for (int i = gapSize, j; i < length; ++i) {
                swapTempNumber = sortedNumbers[i];
                for (j = i - gapSize; j >= 0; j -= gapSize) {
                    ++conditionCounter;
                    if (sortedNumbers[j] <= swapTempNumber) break;

                    ++swapCounter;
                    sortedNumbers[j + gapSize] = sortedNumbers[j];
                }
                ++swapCounter;
                sortedNumbers[j + gapSize] = swapTempNumber;
            }
        }

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return sortedNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Shell Sort";
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
