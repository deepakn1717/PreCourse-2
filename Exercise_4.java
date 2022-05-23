class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int leftArray[], int rightArray[]) {
        // Your code here
        /**
         * index pointer for each array, arr ==> x, leftArray ==> y, rightArray=> z
         * compare values of y and z then save the least value to x
         * repeat above step untill one the child array are empty and saved to master
         * child array remaining will be added to master array
         */
        int x = 0, y = 0, z = 0;
        while (y < leftArray.length && z < rightArray.length) {
            if (leftArray[y] < rightArray[z]) {
                arr[x] = leftArray[y];
                x++;
                y++;
            } else {
                arr[x] = rightArray[z];
                x++;
                z++;
            }
        }
        if (y < leftArray.length) {
            for (int i = y; i < leftArray.length; i++) {
                arr[x] = leftArray[i];
                x++;
            }
        }
        if (z < rightArray.length) {
            for (int i = z; i < rightArray.length; i++) {
                arr[x] = rightArray[i];
                x++;
            }
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[]) {
        // Write your code here
        // Call mergeSort from here
        /**
         * get mid index from the array
         * build leftArray and rightArray
         * repeat this untill size of array index is less than 2
         * finally merge leftArray and rightArray back to root array in sorting order
         */
        int lenght = arr.length;

        if (lenght < 2)
            return;
        int mid = lenght / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[lenght - mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = arr[i];
        }
        for (int i = mid; i < lenght; i++) {
            rightArray[i - mid] = arr[i];
        }
        sort(leftArray);
        sort(rightArray);
        merge(arr, leftArray, rightArray);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7, 0, 0 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}