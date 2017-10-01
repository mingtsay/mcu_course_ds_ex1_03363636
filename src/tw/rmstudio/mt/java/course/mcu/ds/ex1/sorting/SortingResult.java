package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting;

public class SortingResult {
    private final String algorithmName;
    private final int[] sortedNumbers;
    private final long elapsedNanoTime;
    private final int conditionTimes, swapTimes;

    SortingResult(String algorithmName, int[] sortedNumbers, long elapsedNanoTime, int conditionTimes, int swapTimes) {
        this.algorithmName = algorithmName;
        this.sortedNumbers = sortedNumbers;
        this.elapsedNanoTime = elapsedNanoTime;
        this.conditionTimes = conditionTimes;
        this.swapTimes = swapTimes;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public int[] getSortedNumbers() {
        return sortedNumbers;
    }

    public long getElapsedNanoTime() {
        return elapsedNanoTime;
    }

    public int getConditionTimes() {
        return conditionTimes;
    }

    public int getSwapTimes() {
        return swapTimes;
    }
}
