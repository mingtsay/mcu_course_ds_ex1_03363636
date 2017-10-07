package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class SelectionSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set

    override val algorithmName: String
        get() = "Selection Sort"

    override fun sort(randomNumbers: IntArray): IntArray {
        var conditionCounter = 0
        var swapCounter = 0
        val length = randomNumbers.size
        val sortedNumbers = Arrays.copyOf(randomNumbers, length)

        for (i in 0 until length - 1) {
            var minIndex = i
            for (j in i + 1 until length) {
                ++conditionCounter
                if (sortedNumbers[minIndex] > sortedNumbers[j]) {
                    minIndex = j
                }
            }

            ++swapCounter
            val swapTempNumber = sortedNumbers[i]
            sortedNumbers[i] = sortedNumbers[minIndex]
            sortedNumbers[minIndex] = swapTempNumber
        }

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
