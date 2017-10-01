package tw.rmstudio.mt.java.course.mcu.ds.ex1;

import tw.rmstudio.mt.java.course.mcu.ds.ex1.sorting.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class Main extends JFrame {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());
    private static final Random random = new Random();
    private static final DefaultListModel emptyModel = getModelByIntArray(new int[0]);
    private static int[] generatedNumbers = new int[0];
    private static int[] sortedNumbers = new int[0];
    private JPanel panelMain;
    private JPanel panelControls;
    private JPanel panelN;
    private JLabel labelN;
    private JTextField txtN;
    private JPanel panelRange;
    private JLabel labelRange;
    private JTextField txtRange;
    private JButton btnGenerate;
    private JCheckBox chkDisplayNumbers;
    private JButton btnBubbleSort;
    private JButton btnSelectionSort;
    private JButton btnInsertionSort;
    private JButton btnMergeSort;
    private JButton btnQuickSort;
    private JButton btnShellSort;
    private JPanel panelDisplay;
    private JPanel panelOutput;
    private JLabel labelOutput;
    private JScrollPane scrollOutput;
    private JTextPane txtOutput;
    private JPanel panelNumbers;
    private JPanel panelGeneratedNumbers;
    private JLabel labelGeneratedNumbers;
    private JScrollPane scrollGeneratedNumbers;
    private JList listGeneratedNumbers;
    private JPanel panelSortedNumbers;
    private JLabel labelSortedNumbers;
    private JScrollPane scrollSortedNumbers;
    private JList listSortedNumbers;

    private Main() {
        logger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord record) {
                String level = record.getLevel().getLocalizedName();
                String message = record.getMessage();
                Document document = txtOutput.getDocument();
                try {
                    document.insertString(document.getLength(), "[" + level + "] " + message + "\n", null);
                } catch (BadLocationException e) {
                    logger.severe(e.getLocalizedMessage());
                    e.printStackTrace();
                }
                txtOutput.setCaretPosition(document.getLength());

                if (Level.WARNING.equals(record.getLevel()))
                    JOptionPane.showMessageDialog(panelMain, record.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        });

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int n = Integer.parseInt(txtN.getText());
                    int range = Integer.parseInt(txtRange.getText());

                    if (n <= 0 || range <= 0) throw new NumberFormatException();

                    generateRandomNumbers(n, range);
                } catch (NumberFormatException ex) {
                    logger.warning("Incorrect input format! Please check the fields and try again.");
                }
            }
        });
        btnBubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new BubbleSort());
            }
        });
        btnSelectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new SelectionSort());
            }
        });
        btnInsertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new InsertionSort());
            }
        });
        btnMergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new MergeSort());
            }
        });
        btnQuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new QuickSort());
            }
        });
        btnShellSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sort(new ShellSort());
            }
        });
    }

    private static DefaultListModel getModelByIntArray(int[] intArray) {
        DefaultListModel model = new DefaultListModel();
        for (int value : intArray) model.addElement(String.valueOf(value));
        return model;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DS_EX1_03363636_蔡璨名 Sorting Algorithm");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(727, 377));
        frame.pack();
        frame.setVisible(true);
    }

    private void setControlsEnabled(boolean state) {
        txtN.setEnabled(state);
        txtRange.setEnabled(state);
        btnGenerate.setEnabled(state);
        chkDisplayNumbers.setEnabled(state);
        btnBubbleSort.setEnabled(state);
        btnSelectionSort.setEnabled(state);
        btnInsertionSort.setEnabled(state);
        btnMergeSort.setEnabled(state);
        btnQuickSort.setEnabled(state);
        btnShellSort.setEnabled(state);
    }

    private void generateRandomNumbers(final int n, final int range) {
        setControlsEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Generating " + n + " numbers in range " + range + "…");

                long timeElapsed = System.nanoTime();

                generatedNumbers = new int[n];
                sortedNumbers = new int[n];

                for (int i = 0; i < n; ++i) {
                    int number = random.nextInt(range) + 1;
                    generatedNumbers[i] = number;
                }

                timeElapsed = System.nanoTime() - timeElapsed;

                logger.info(n + " numbers in range " + range + " have been generated in " + timeElapsed / 1000000f + "ms.");
                listGeneratedNumbers.setModel(chkDisplayNumbers.isSelected() ? getModelByIntArray(generatedNumbers) : emptyModel);
                listSortedNumbers.setModel(emptyModel);
                setControlsEnabled(true);
            }
        }).start();
    }

    private void sort(final SortingAlgorithm sortingAlgorithm) {
        setControlsEnabled(false);
        logger.info("Sorting with \"" + sortingAlgorithm.getAlgorithmName() + "\"…");
        new Thread(new Runnable() {
            @Override
            public void run() {
                SortingResult result = sortingAlgorithm.sortResult(generatedNumbers);
                sortedNumbers = result.getSortedNumbers();
                logger.info("Sorted in " + result.getElapsedNanoTime() / 1000000f + "ms with \"" + result.getAlgorithmName() + "\". Condition " + result.getConditionTimes() + " times. Swap " + result.getSwapTimes() + " times.");
                listSortedNumbers.setModel(chkDisplayNumbers.isSelected() ? getModelByIntArray(sortedNumbers) : emptyModel);
                setControlsEnabled(true);
            }
        }).start();
        if (generatedNumbers.length < 1)
            logger.warning("Random numbers are not generated yet. The result might not be useful.");
    }
}
