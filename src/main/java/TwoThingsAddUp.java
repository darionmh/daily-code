import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Darion Higgins on 7/11/2019
 * TSO2438
 */
public class TwoThingsAddUp {
    /* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17. */

    public static void main(String[] args) {
        int[] nums = new int[] {10, 15, 3, 7};
        int k = 17;

        System.out.println(valid2(Arrays.asList(10, 15, 3, 7), k));
    }

    static boolean valid(int[] arr, int k){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j + i<arr.length;j++)
                if(arr[i] + arr[i + j] == k) return true;
        }

        return false;
    }

    static boolean valid(List<Integer> arr, int k){
        for (Integer v : arr) {
            if(arr.contains(Math.abs(v - k))) return true;
        }
        return false;
    }

    static boolean valid2(List<Integer> arr, int k){
        List<Integer> valuesToFind = new ArrayList<>();
        for (Integer i : arr) {
            if(valuesToFind.contains(i)) return true;
            valuesToFind.add(Math.abs(i - k));
        }
        return false;
    }
}
