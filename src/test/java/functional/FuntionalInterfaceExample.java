package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntionalInterfaceExample {

    public static void main(String[] args) {
        //Function
        Function<String, Integer> toInt = value  -> Integer.parseInt(value);

        Integer apply = toInt.apply("100");
        System.out.println(apply);

        final Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(9999));

        //Consumer
        final Consumer<String> print = value  -> System.out.println(value);
        final Consumer<String> greetings = value  -> System.out.println("greeting " + value );

        print.accept("wow");
        greetings.accept("wow");

        //Predicate
        Predicate<Integer> isPositive = value ->  value > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if(isPositive.test(number)){
                positiveNumbers.add(number);
            }
        }
        System.out.println("Positive Number:" + positiveNumbers);

        List<Integer> numbersLessThan3 = new ArrayList<>();
        Predicate<Integer> lessThan3 = value -> value < 3;
        for (Integer number : numbers) {
            if(lessThan3.test(number)){
                numbersLessThan3.add(number);
            }
        }
        System.out.println("numbersLessThan3 Number:" + numbersLessThan3);

        System.out.println("positive integers:" + filter(numbers, value -> value > 0));
        System.out.println("less than 3: " + filter(numbers, lessThan3));

        //Supplier
        final Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "world");

        long start = System.currentTimeMillis();
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(1, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - start)/1000 )  + " seconds.");
    }

    private static String getVeryExpensiveValue(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Kebin";
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier){
        if(number > 0){
            System.out.println("The value is " + valueSupplier.get() +  ".");
        }
        else{
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if(filter.test(input)){
                result.add(input);
            }
        }
        return result;
    }
}
