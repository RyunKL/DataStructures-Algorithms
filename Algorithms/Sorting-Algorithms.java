import java.util.Random;
import java.util.Arrays;
public class Main {
    /**
     * NAME: Selection Sort
     *  - iterates through the entire array and swaps indices with the lower value
     * RUN TIME COMPLEXITY: O(n^2) = Quadratic Time
     *  - the larger the data size the more in-efficient it is to use
     *  - similar speed with insertion sort, and bubble sort
     *  - small data = ok | big data = BAD
     */
    public static void selectionSort(int[] array){

        //searches each index one by one
        for(int i = 0; i < array.length - 1; i++){
            //set the current smallest value as the first index
            int min = i;

            //search throughout the array for a smaller value
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]) { min = j; }

                //swap the current smallest value with the newfound smallest value
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
     /**
     * NAME: Insertion Sort
     *  - after comparing elements to the left shift elements to the right to make room to insert a value
     * RUN TIME COMPLEXITY: O(n^2) = Quadratic Time
     *  - the larger the data size the more in-efficient it is to use
     *  - fewer steps than bubbleSort
     *  - best case is O(n) compared to Selection Sort O(n^2)
     *  - small data = decent | big data = BAD
     */
    public static void insertionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
     /**
     * NAME: Bubble Sort
     *  - pairs of adjacent elements are compared,
     *  and the elements swapped if they are not in order
     * RUN TIME COMPLEXITY: O(n^2) = Quadratic Time
     *  - the larger the data size the more in-efficient it is to use
     *  - small data = decent | big data = BAD
     */
    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    //Uses recursion divide and conquer technique
    public static void quickSort(int[] array, int start, int end){
        if(end <= start) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++){
            if(array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
    //MergeSort = recursively divide array into 2, sorts, re-combine
    //run-time complexity = 0(log n) - quasilinear time (looks quadratic to me)
    //                               - similar run time of quicksort, heapsort
    //                               - faster than: insertion, selection, and bubble sort
    //space complexity = 0(n) - linear space
    public static void mergeSort(int[] array){
        int length = array.length;
        if(length <= 1) return;

        int middle = length/2;
        int [] left = new int[middle];
        int [] right = new int[length - middle];

        int i = 0;// left array
        int j = 0;// right array

        for(; i < length; i++){
            if(i < middle){
                left[i] = array[i];
            }else{
                right[j] = array[i];
                j++;
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }
    private static void merge(int[] left, int[] right, int[] array){
        //Sub function of the mergeSort
        int leftLength = left.length/2;
        int rightLength = right.length - leftLength;
        int i = 0, l = 0, r = 0; // indices

        //check conditions for merge
        while(l < leftLength && r < rightLength){
            if(left[l] < right[r]){
                array[i] = left[l];
                i++;
                l++;
            }else{
                array[i] = right[r];
                i++;
                r++;
            }
        }
        while(l < leftLength){
            array[i] = left[l];
            i++;
            l++;
        }
        while(r < rightLength){
            array[i] = right[r];
            i++;
            r++;
        }
    }
    public static void main(String[] args) {
        //Creating an unorganized array to be sorted
        //lets make them 20 indices long for this example
        Random rand = new Random();
        int[] array = new int[20];
        int[] array2 = new int[20];
        int[] array3 = new int[20];
        int[] array4 = new int[20];
        int[] array5 = new int[20];

        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
            array2[i] = rand.nextInt(100);
            array3[i] = rand.nextInt(100);
            array4[i] = rand.nextInt(100);
            array5[i] = rand.nextInt(100);
        }
        //Printing unorganized Arrays
        System.out.println("-------------------------UnOrdered Arrays-------------------------");
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));

        //Calling on each Sorting Algorithm
        selectionSort(array);
        insertionSort(array2);
        bubbleSort(array3);
        mergeSort(array4);
        quickSort(array5, 0, 19);

        //Printing Organized Arrays Ascending
        System.out.println("\n-------------------------Organized Ascending Arrays-------------------------")
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
    }
}
