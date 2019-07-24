import java.util.Arrays;

/**
 * Created by Darion Higgins on 7/12/2019
 * TSO2438
 */
public class ArrayProducts {
    //Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
    //For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
    //Follow-up: what if you can't use division?

    public static void main(String[] args) {
        new ArrayProducts().testTheThing();
    }

    void testTheThing() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] output = new int[]{120, 60, 40, 30, 24};
        System.out.println(Arrays.equals(output, doTheThing(input)));
    }


    int[] doTheThing(int[] arr) {
        int[] vals = new int[arr.length];
        Arrays.fill(vals, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < vals.length; i1++) {
                if(i == i1) continue;

                vals[i1] *= arr[i];
            }
        }

        return vals;
    }
}
