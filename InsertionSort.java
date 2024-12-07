
import java.util.Arrays;

public class InsertionSort {
    // EXAMPLE  arr[] = {5, 2, 4, 3, 4}

    // START LOOP 1 
    // key = 2
    // int j = 0, arr[j] = 5
    // while = true
    // arr[1] = arr[0]
    // j--, j = -1
    // j - 1 = 0, arr[0] = key = 2
    // END LOOP 1
    // arr[] = {2, 5, 4, 3, 4}
    // START LOOP 2
    // key = arr[2] = 4
    // j = 1, arr[j] = 5
    // while = true
    // arr[2] = arr[1] = 5
    // j--, j = 0
    // while = true
    // arr[1] = arr[0] = 2
    // arr[1] = 6
    // END LOOP 2
    // arr[] = {2, 4, 5, 3, 4}
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1], that are greater than key, to one position ahead.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        int[] smallArray = {3, 1, 4, 1, 5};
        int[] largeArray = new int[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = 1000 - i; // Reversed array
        }
        int[] nearlySortedArray = {1, 2, 3, 4, 6, 5, 7, 8};
        int[] reversedArray = {5, 4, 3, 2, 1};

        // Test each case
        testAndPrint("Small Array", smallArray);
        testAndPrint("Large Array", largeArray);
        testAndPrint("Nearly Sorted Array", nearlySortedArray);
        testAndPrint("Reversed Array", reversedArray);
    }

    private static void testAndPrint(String testName, int[] array) {
        System.out.println(testName + " - Before: " + Arrays.toString(array));
        InsertionSort.insertionSort(array);
        System.out.println(testName + " - After: " + Arrays.toString(array));
        System.out.println();
    }
}
