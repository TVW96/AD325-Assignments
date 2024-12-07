
public class SelectionSort {

    // Method to implement Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to implement a descending selection sort
    public static void selectionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
        }
    }

    // Method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the selectionSort implementation
    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = (int) Math.floor(Math.random() * 10);
        };
        System.out.println("Original Array:");
        printArray(arr1);
        selectionSort(arr1);
        System.out.println("Sorted Array:");
        printArray(arr1);

        // Test case 2: Already sorted array
        int[] arr2 = {11, 23, 35, 42, 56};
        System.out.println("Original Array:");
        printArray(arr2);
        selectionSort(arr2);
        System.out.println("Sorted Array:");
        printArray(arr2);

        // Test case 3: Array sorted in descending order
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Original Array:");
        printArray(arr3);
        selectionSort(arr3);
        System.out.println("Sorted Array:");
        printArray(arr3);

        // Test case 4: Array with all elements the same
        int[] arr4 = {5, 5, 5, 5, 5};
        System.out.println("Original Array:");
        printArray(arr4);
        selectionSort(arr4);
        System.out.println("Sorted Array:");
        printArray(arr4);

        // Test case 5: Empty array
        int[] arr5 = {};
        System.out.println("Original Array:");
        printArray(arr5);
        selectionSort(arr5);
        System.out.println("Sorted Array:");
        printArray(arr5);

        // Test case 6: Array with one element
        int[] arr6 = {42};
        System.out.println("Original Array:");
        printArray(arr6);
        selectionSort(arr6);
        System.out.println("Sorted Array:");
        printArray(arr6);
    }
}
