package functional;

import java.math.BigDecimal;

public class FuntionalInterfaceExample3 {

    public static void main(String[] args) {
        BigDecimalToCurrency bigDecimalToCurrency = (value) -> "$" + value;
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("123.100")));

        final InvalidFunctionInterface anonymousClass = new InvalidFunctionInterface() {
            @Override
            public <T> String makeString(T value) {
                return value.toString();
            }
        };

        System.out.println(anonymousClass.makeString(123));

//        final functional.InvalidFunctionInterface invalidFunctionInterface = value -> value.toString(); //compile error
//        System.out.println(invalidFunctionInterface.makeString(123));
    }


}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionInterface {
    <T> String makeString(T value);
}

