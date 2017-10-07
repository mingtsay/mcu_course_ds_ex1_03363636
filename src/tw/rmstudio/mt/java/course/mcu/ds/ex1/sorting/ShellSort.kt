package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class ShellSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set

    override val algorithmName: String
        get() = "Shell Sort"

    override fun sort(randomNumbers: IntArray): IntArray {
        var conditionCounter = 0
        var swapCounter = 0
        val length = randomNumbers.size
        val sortedNumbers = Arrays.copyOf(randomNumbers, length)

        var swapTempNumber: Int
        var gapSize = 1

        while (gapSize < length / 3) gapSize = gapSize * 3 + 1

        while (gapSize > 0) {
            var i = gapSize
            while (i < length) {
                swapTempNumber = sortedNumbers[i]
                var j = i - gapSize
                while (j >= 0) {
                    ++conditionCounter
                    if (sortedNumbers[j] <= swapTempNumber) break

                    ++swapCounter
                    sortedNumbers[j + gapSize] = sortedNumbers[j]
                    j -= gapSize
                }
                ++swapCounter
                sortedNumbers[j + gapSize] = swapTempNumber
                ++i
            }
            gapSize /= 3
        }

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
