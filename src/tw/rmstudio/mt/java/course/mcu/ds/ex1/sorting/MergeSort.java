package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {
    private int lastConditionCount = -1, lastSwapCount = -1;

    @Override
    int[] sort(int[] randomNumbers) {
        int conditionCounter = 0, swapCounter = 0;

        int length = randomNumbers.length;
        int[] sortedNumbers = new int[length], sourceNumbers = Arrays.copyOf(randomNumbers, length);
        int block, index;

        for (block = 1; block < length * 2 /* ?! */ ; block *= 2) {
            for (index = 0; index < length; index += block * 2) {
                int center = Math.min(index + block, length), upper = Math.min(index + block * 2, length);
                int k = index, indexA = index, indexB = center;

                while (indexA < center && indexB < upper) {
                    sortedNumbers[k++] = sourceNumbers[indexA] < sourceNumbers[indexB] ? sourceNumbers[indexA++] : sourceNumbers[indexB++];
                    ++conditionCounter;
                }

                while (indexA < center) sortedNumbers[k++] = sourceNumbers[indexA++];
                while (indexB < upper) sortedNumbers[k++] = sourceNumbers[indexB++];
            }

            ++swapCounter;
            int[] swapTempArray = sourceNumbers;
            sourceNumbers = sortedNumbers;
            sortedNumbers = swapTempArray;
        }
        sortedNumbers = sourceNumbers;

        lastConditionCount = conditionCounter;
        lastSwapCount = swapCounter;
        return sortedNumbers;
    }

    @Override
    public String getAlgorithmName() {
        return "Merge Sort";
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
