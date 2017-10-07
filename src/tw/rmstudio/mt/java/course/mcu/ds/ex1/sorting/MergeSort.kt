package tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting

import java.util.*

class MergeSort : SortingAlgorithm() {
    override var conditionCount = -1
        private set
    override var swapCount = -1
        private set

    override val algorithmName: String
        get() = "Merge Sort"

    override fun sort(randomNumbers: IntArray): IntArray {
        var conditionCounter = 0
        var swapCounter = 0

        val length = randomNumbers.size
        var sortedNumbers = IntArray(length)
        var sourceNumbers = Arrays.copyOf(randomNumbers, length)
        var block = 1
        var index: Int

        while (block < length * 2) {
            index = 0
            while (index < length) {
                val center = Math.min(index + block, length)
                val upper = Math.min(index + block * 2, length)
                var k = index
                var indexA = index
                var indexB = center

                while (indexA < center && indexB < upper) {
                    sortedNumbers[k++] = if (sourceNumbers[indexA] < sourceNumbers[indexB]) sourceNumbers[indexA++] else sourceNumbers[indexB++]
                    ++conditionCounter
                }

                while (indexA < center) sortedNumbers[k++] = sourceNumbers[indexA++]
                while (indexB < upper) sortedNumbers[k++] = sourceNumbers[indexB++]
                index += block * 2
            }

            ++swapCounter
            val swapTempArray = sourceNumbers
            sourceNumbers = sortedNumbers
            sortedNumbers = swapTempArray
            block *= 2
        }
        sortedNumbers = sourceNumbers

        conditionCount = conditionCounter
        swapCount = swapCounter
        return sortedNumbers
    }
}
