package higherorder;

import java.util.function.Function;

public class HigherOrderFunctionExamples {
    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);
        System.out.println(f.apply(i -> "#" + i));

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
        System.out.println(f2.apply(1).apply(9));
    }
}
