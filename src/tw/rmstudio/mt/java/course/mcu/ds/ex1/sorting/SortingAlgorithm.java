package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

public abstract class SortingAlgorithm {
    abstract int[] sort(int[] randomNumbers);

    public abstract String getAlgorithmName();

    abstract int getConditionCount();

    abstract int getSwapCount();

    public SortingResult sortResult(int[] randomNumbers) {
        long startTime, endTime;
        int[] sortedNumbers;

        startTime = System.nanoTime();
        sortedNumbers = sort(randomNumbers);
        endTime = System.nanoTime();

        return new SortingResult(getAlgorithmName(), sortedNumbers, endTime - startTime, getConditionCount(), getSwapCount());
    }
}
