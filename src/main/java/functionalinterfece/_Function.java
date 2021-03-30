package functionalinterfece;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function takes one argument and produces one result
        int increment = increment(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> incrementByOneThenMultiplyBy10 = incrementByOneFunction
                .andThen(multiplyBy10Function);
        System.out.println(incrementByOneThenMultiplyBy10.apply(4));

        // BiFunction takes two argument and produces one result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (number, numberToMultiplyBy)
            -> (++number) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
        return (++number) * numberToMultiplyBy;
    }
}
