import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Darion Higgins on 7/16/2019
 * TSO2438
 */
public class Pairs {
    //cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
    //Given this implementation of cons:
    //def cons(a, b):
    //    def pair(f):
    //        return f(a, b)
    //    return pair
    //Implement car and cdr.

    public static void main(String[] args) {
        boolean res1 = car(cons(3,4)) == 3;
        boolean res2 = cdr(cons(3,4)) == 4;

        System.out.println(res1 + " " + res2);
    }

    @Test
    void test(){
        Assert.assertEquals(3, car(cons(3,4)));
    }
    
    interface PairFunction {
        int apply(int a, int b);
    }

    static Function<PairFunction, Integer> cons(int a, int b) {
        return o -> o.apply(a, b);
    }

    static int car(Function<PairFunction, Integer> c){
        return c.apply(((a, b) -> a));
    }

    static int cdr(Function<PairFunction, Integer> c){
        return c.apply(((a, b) -> b));
    }
}
