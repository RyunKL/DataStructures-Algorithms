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
    public static void insertionSort(int[] array){
        //Code here
    }
    public static void bubbleSort(int[] array){
        //Code here
    }
    public static void mergeSort(int[] array){
        //Code here
    }
    public static void merge(int[] left, int[] right, int[] array){
        //Sub function of the mergeSort
    }
    public static void main(String[] args) {
        //Creating an unorganized array to be sorted
        //lets make them 20 indices long for this example
        Random rand = new Random();
        int[] array = new int[20];
        int[] array2 = new int[20];
        int[] array3 = new int[20];
        int[] array4 = new int[20];

        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
            array2[i] = rand.nextInt(100);
            array3[i] = rand.nextInt(100);
            array4[i] = rand.nextInt(100);
        }
        //Printing unorganized Arrays
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));

        //Calling on each Sorting Algorithm
        selectionSort(array);

        //Printing Organized Arrays Ascending
        System.out.println(Arrays.toString(array));
    }
}
