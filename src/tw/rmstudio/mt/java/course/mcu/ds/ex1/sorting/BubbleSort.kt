package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class BubbleSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set

    override val algorithmName: String
        get() = "Bubble Sort"

    override fun sort(randomNumbers: IntArray): IntArray {
        var conditionCounter = 0
        var swapCounter = 0
        val length = randomNumbers.size
        val sortedNumbers = Arrays.copyOf(randomNumbers, length)

        for (i in 0 until length) {
            for (j in 0 until length - i - 1) {
                ++conditionCounter
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    ++swapCounter
                    val swapTempNumber = sortedNumbers[j]
                    sortedNumbers[j] = sortedNumbers[j + 1]
                    sortedNumbers[j + 1] = swapTempNumber
                }
            }
        }

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
