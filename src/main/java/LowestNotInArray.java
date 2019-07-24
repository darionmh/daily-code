import java.util.Arrays;

/**
 * Created by Darion Higgins on 7/15/2019
 * TSO2438
 */
public class LowestNotInArray {
    //In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
    //For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
    //You can modify the input array in-place.

    public static void main(String[] args) {
        System.out.println(new LowestNotInArray().find(new int[]{3, 4, -1, 1}) == 2);
        System.out.println(new LowestNotInArray().find(new int[]{1, 2, 0}) == 3);
    }

    int find(int[] arr) {
        Arrays.sort(arr);

        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) val = arr[i] + 1;

            else if (arr[i + 1] - arr[i] != 1 && arr[i] + 1 != 0) {
                val = arr[i] + 1;
                break;
            }
        }

        return val < 0 ? 0 : val;
    }
}
