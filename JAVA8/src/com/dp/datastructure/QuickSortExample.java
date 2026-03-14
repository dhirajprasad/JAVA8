package com.dp.datastructure;

public class QuickSortExample {
	// Function to perform Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
    	int i=0;
        if (low < high) {
        	
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            System.out.println("pivotIndex Array:" +pivotIndex);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            System.out.println("Original Array:" +i++);
            printArray(arr);
            quickSort(arr, pivotIndex + 1, high);
            printArray(arr);
        }
    }
 // Function to partition the array
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1 position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partitioning index
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
public static void main(String[] args) {
	int[] array = {1, 4, 7, 3, 10, 5};

    System.out.println("Original Array:");
    printArray(array);

    quickSort(array, 0, array.length - 1);

    System.out.println("Sorted Array:");
    printArray(array);
}

}
