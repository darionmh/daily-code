package fofun;

import java.util.Arrays;

/**
 * Created by Darion Higgins on 7/11/2019
 * TSO2438
 */
public class Subseq {
    //Input: arr[] = {1, 4, 3, 2, 5}, K = 4
    //Output: 4 3 2 5
    //Two subarrays are {1, 4, 3, 2} and {4, 3, 2, 5}.
    //Hence, the greater one is {4, 3, 2, 5}
    //
    //Input: arr[] = {1, 9, 2, 7, 9, 3}, K = 3
    //Output: 9 2 7

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Subseq().greatestSubseq(new int[]{1,4,3,2,5}, 4)));
        System.out.println(Arrays.toString(new Subseq().greatestSubseq(new int[]{1, 9, 2, 7, 9, 3}, 3)));
    }

    int[] greatestSubseq(int[] arr, int k){
        int greatestSum = 0;
        int startingI = 0;

        for(int i=0;i<arr.length-k + 1;i++){
            int sum = 0;
            for(int j=i; j < i+k; j++){
                sum += arr[j];
            }

            if(sum > greatestSum){
                greatestSum = sum;
                startingI = i;
            }
        }

        int[] res = new int[k];
        for(int i=startingI;i<startingI + k;i++){
            res[i-startingI] = arr[i];
        }

        return res;
    }
}
