import java.util.Arrays;
public class Main {
    public static int linearSearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                System.out.println("Hurray! the number: " + key + " was found on index: " + i);
                return i;
            }
        }System.out.println("Error, the number: " + key + " was not found");
        return -1;
    }
    public static int binarySearch(int[] arr, int key){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == key){
                System.out.println("Hurray! the number: " + key + " was found on index: " + mid);
                return mid;
            }if(arr[mid] < key) lo = mid + 1;
            if(arr[mid] > key) hi = mid - 1;
        }System.out.println("Error, the number: " + key + " was not found");
        return -1;
    }
    public static void main(String[] args) {
        int [] array = {15, 34, 19, 25, 67, 88, 93, 0, 32, 15};
        Arrays.sort(array);

        //Sorted Array
        System.out.println(Arrays.toString(array));

        //Search Algorithms
        binarySearch(array, 67);
        linearSearch(array, 0);
    }
}
