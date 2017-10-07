package tw.rmstudio.mt.java.course.mcu.ds.ex1

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.*
import java.awt.Dimension
import java.util.*
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import javax.swing.DefaultListModel
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.text.BadLocationException

class Main private constructor() {
    private val logger = Logger.getLogger(MainForm::class.java.canonicalName)
    private val random = Random()
    private val emptyModel = getModelByIntArray(IntArray(0))
    private var generatedNumbers = IntArray(0)
    private var sortedNumbers = IntArray(0)
    private var mainForm = MainForm()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main()
        }
    }

    private fun getModelByIntArray(intArray: IntArray): DefaultListModel {
        val model = DefaultListModel()
        for (value in intArray) model.addElement(value.toString())
        return model
    }

    private fun generateRandomNumbers(n: Int, range: Int) {
        setControlsEnabled(false)
        Thread(Runnable {
            logger.info("Generating $n numbers in range $range…")

            var timeElapsed = System.nanoTime()

            generatedNumbers = IntArray(n)
            sortedNumbers = IntArray(n)

            for (i in 0 until n) {
                val number = random.nextInt(range) + 1
                generatedNumbers[i] = number
            }

            timeElapsed = System.nanoTime() - timeElapsed

            logger.info(n.toString() + " numbers in range " + range + " have been generated in " + timeElapsed / 1000000f + "ms.")
            mainForm.listGeneratedNumbers.model = if (mainForm.chkDisplayNumbers.isSelected) getModelByIntArray(generatedNumbers) else emptyModel
            mainForm.listSortedNumbers.model = emptyModel
            setControlsEnabled(true)
        }).start()
    }

    private fun setControlsEnabled(state: Boolean) {
        mainForm.txtN.isEnabled = state
        mainForm.txtRange.isEnabled = state
        mainForm.btnGenerate.isEnabled = state
        mainForm.chkDisplayNumbers.isEnabled = state
        mainForm.btnBubbleSort.isEnabled = state
        mainForm.btnSelectionSort.isEnabled = state
        mainForm.btnInsertionSort.isEnabled = state
        mainForm.btnMergeSort.isEnabled = state
        mainForm.btnQuickSort.isEnabled = state
        mainForm.btnShellSort.isEnabled = state
    }

    private fun sort(sortingAlgorithm: SortingAlgorithm) {
        setControlsEnabled(false)
        logger.info("Sorting with \"" + sortingAlgorithm.algorithmName + "\"…")
        Thread(Runnable {
            val result = sortingAlgorithm.sortResult(generatedNumbers)
            sortedNumbers = result.sortedNumbers
            logger.info("Sorted in " + result.elapsedNanoTime / 1000000f + "ms with \"" + result.algorithmName + "\". Condition " + result.conditionTimes + " times. Swap " + result.swapTimes + " times.")
            mainForm.listSortedNumbers.model = if (mainForm.chkDisplayNumbers.isSelected) getModelByIntArray(sortedNumbers) else emptyModel
            setControlsEnabled(true)
        }).start()
        if (generatedNumbers.isEmpty())
            logger.warning("Random numbers are not generated yet. The result might not be useful.")
    }

    init {
        val frame = JFrame("DS_EX1_03363636_蔡璨名 Sorting Algorithm")
        frame.contentPane = mainForm.panelMain
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.minimumSize = Dimension(727, 377)
        frame.pack()
        frame.isVisible = true
        logger.addHandler(object : Handler() {
            override fun publish(record: LogRecord) {
                val level = record.level.localizedName
                val message = record.message
                val document = mainForm.txtOutput.document
                try {
                    document.insertString(document.length, "[$level] $message\n", null)
                } catch (e: BadLocationException) {
                    logger.severe(e.localizedMessage)
                    e.printStackTrace()
                }

                mainForm.txtOutput.caretPosition = document.length

                if (Level.WARNING == record.level)
                    JOptionPane.showMessageDialog(mainForm.panelMain, record.message, "Warning", JOptionPane.WARNING_MESSAGE)
            }

            override fun flush() {

            }

            @Throws(SecurityException::class)
            override fun close() {

            }
        })
        mainForm.btnGenerate.addActionListener({
            try {
                val n = Integer.parseInt(mainForm.txtN.text)
                val range = Integer.parseInt(mainForm.txtRange.text)

                if (n <= 0 || range <= 0) throw NumberFormatException()

                generateRandomNumbers(n, range)
            } catch (ex: NumberFormatException) {
                logger.warning("Incorrect input format! Please check the fields and try again.")
            }
        })
        mainForm.btnBubbleSort.addActionListener({ sort(BubbleSort()) })
        mainForm.btnSelectionSort.addActionListener({ sort(SelectionSort()) })
        mainForm.btnInsertionSort.addActionListener({ sort(InsertionSort()) })
        mainForm.btnMergeSort.addActionListener({ sort(MergeSort()) })
        mainForm.btnQuickSort.addActionListener({ sort(QuickSort()) })
        mainForm.btnShellSort.addActionListener({ sort(ShellSort()) })
    }
}
