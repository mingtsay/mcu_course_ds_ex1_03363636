package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

abstract class SortingAlgorithm {

    abstract val algorithmName: String

    internal abstract val conditionCount: Int

    internal abstract val swapCount: Int
    internal abstract fun sort(randomNumbers: IntArray): IntArray

    fun sortResult(randomNumbers: IntArray): SortingResult {
        val startTime = System.nanoTime()
        val sortedNumbers = sort(randomNumbers)
        val endTime = System.nanoTime()

        return SortingResult(algorithmName, sortedNumbers, endTime - startTime, conditionCount, swapCount)
    }
}
