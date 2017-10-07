package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class InsertionSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set

    override val algorithmName: String
        get() = "Insertion Sort"

    override fun sort(randomNumbers: IntArray): IntArray {
        var conditionCounter = 0
        var swapCounter = 0
        val length = randomNumbers.size
        val sortedNumbers = Arrays.copyOf(randomNumbers, length)

        for (i in 1 until length) {
            val swapTempNumber = sortedNumbers[i]
            var j = i - 1
            while (j >= 0) {
                ++conditionCounter
                if (sortedNumbers[j] <= swapTempNumber) break

                ++swapCounter
                sortedNumbers[j + 1] = sortedNumbers[j]
                --j
            }
            ++swapCounter
            sortedNumbers[j + 1] = swapTempNumber
        }

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
