package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class QuickSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set
    private var conditionCounter = 0
    private var swapCounter = 0

    override val algorithmName: String
        get() = "Quick Sort"

    private fun quickSort(randomNumbers: IntArray): IntArray {
        var swapTempNumber: Int
        val length = randomNumbers.size
        if (length < 2) return randomNumbers
        val sortedNumbers = Arrays.copyOf(randomNumbers, length)

        var pivotIndex = 0
        for (i in 1 until length) {
            ++conditionCounter
            if (sortedNumbers[i] < sortedNumbers[0]) {
                ++pivotIndex
                ++swapCounter
                swapTempNumber = sortedNumbers[pivotIndex]
                sortedNumbers[pivotIndex] = sortedNumbers[i]
                sortedNumbers[i] = swapTempNumber
            }
        }

        ++swapCounter
        swapTempNumber = sortedNumbers[pivotIndex]
        sortedNumbers[pivotIndex] = sortedNumbers[0]
        sortedNumbers[0] = swapTempNumber

        var partialSortedNumbers: IntArray
        if (pivotIndex > 1) {
            partialSortedNumbers = quickSort(Arrays.copyOfRange(sortedNumbers, 0, pivotIndex))
            System.arraycopy(partialSortedNumbers, 0, sortedNumbers, 0, partialSortedNumbers.size)
        }
        if (pivotIndex + 1 < length - 1) {
            partialSortedNumbers = quickSort(Arrays.copyOfRange(sortedNumbers, pivotIndex + 1, length))
            System.arraycopy(partialSortedNumbers, 0, sortedNumbers, pivotIndex + 1, partialSortedNumbers.size)
        }

        return sortedNumbers
    }

    override fun sort(randomNumbers: IntArray): IntArray {
        var sortedNumbers = randomNumbers
        conditionCounter = 0
        swapCounter = 0

        sortedNumbers = quickSort(sortedNumbers)

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
