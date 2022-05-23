class BinarySearch {
    // Returns index of x if it is present in arr[l.. r], else return -1
    int binarySearch(int arr[], int first, int last, int x) {
        // Write your code here
        /**
         * variables are first, last, middle
         * 
         * algorithm:
         * if first > last return -1
         * get middle value
         * if x == middle return
         * if x < middle binarySearch(int arr[], int first, int middle-1, int x)
         * if x > middle binarySearch(int arr[], int middle + 1, int last, int x)
         * 
         * Notes: always return recursive function
         */
        if (first > last) {
            return -1;
        }
        int middle = (first + last) / 2;
        if (arr[middle] == x) {
            return middle;
        }
        if (x < arr[middle]) {
            return binarySearch(arr, first, middle - 1, x);
        }
        if (x > arr[middle]) {
            return binarySearch(arr, middle + 1, last, x);
        }
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40, 70 };
        int n = arr.length;
        int x = 2;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
