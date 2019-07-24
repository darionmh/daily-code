package fofun;

/**
 * Created by Darion Higgins on 7/11/2019
 * TSO2438
 */
public class LetterDist {
    //Input : S1 = abcdefghijklmnopqrstuvwxyz, S2 = cba
    //Output : 4

    public static void main(String[] args) {
        System.out.println(4 == distance("abcdefghijklmnopqrstuvwxyz", "cba"));
    }

    static int distance(String base, String in){
        int i = 0, sum = 0;

        for(int j=0;j<in.length();j++){
            sum += Math.abs(i - (i = base.indexOf(in.charAt(j))));
        }

        return sum;
    }
}
