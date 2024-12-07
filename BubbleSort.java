
public class BubbleSort {

    // Basic Bubble Sort implementation
    public static int comparisons = 0; // Count of comparisons
    public static int swaps = 0;       // Count of swaps

    public static void bubbleSort(int[] array) {
        comparisons = 0;
        swaps = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++; // Increment for each comparison
                if (array[j] > array[j + 1]) {
                    swaps++; // Increment for each swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Optimized Bubble Sort implementation
    public static void bubbleSortOptimized(int[] array) {
        comparisons = 0;
        swaps = 0;
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++; // Increment for each comparison
                if (array[j] > array[j + 1]) {
                    swaps++; // Increment for each swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // Exit early if no swaps occurred

            }
        }
    }

    // Comphrehensive suite of test cases
    public static void main(String[] args) {
        int[][] testCases = {
            {64, 34, 25, 12, 22, 11, 90}, // Random Array
            {1, 2, 3, 4, 5, 6, 7, 8, 9}, // Already Sorted
            {9, 8, 7, 6, 5, 4, 3, 2, 1}, // Reversed Array
            {7, 7, 7, 7, 7}, // Identical Elements
            {}, // Empty Array
            {42}, // Single Element
            {-3, -1, -4, -2, 0, 2, 1}, // Array with Negative Numbers
            {5, 3, 8, 3, 9, 1, 3} // Mixed Array with Duplicates
        };

        System.out.println("Basic Bubble Sort Complexity Analysis:");
        for (int i = 0; i < testCases.length; i++) {
            int[] array = testCases[i].clone();
            BubbleSort.bubbleSort(array);
            System.out.printf("Test Case %d: Comparisons = %d, Swaps = %d\n", i + 1, BubbleSort.comparisons, BubbleSort.swaps);
        }

        System.out.println("\nOptimized Bubble Sort Complexity Analysis:");
        for (int i = 0; i < testCases.length; i++) {
            int[] array = testCases[i].clone();
            BubbleSort.bubbleSortOptimized(array);
            System.out.printf("Test Case %d: Comparisons = %d, Swaps = %d\n", i + 1, BubbleSort.comparisons, BubbleSort.swaps);
        }
    }
}
