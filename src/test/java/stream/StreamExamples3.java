package stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples3 {
    public static void main(String[] args) {
//        final List<Integer> numbers

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(toList())
        );

        System.out.println(
            Stream.of(1, 2, 3, 5, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(toSet())
        );

        System.out.println(
            Stream.of(1, 2, 3, 5, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(joining())
        );

        System.out.println(
            Stream.of(1, 2, 3, 5, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .collect(joining(", "))
        );

        System.out.println(
                Stream.of(1, 2, 3, 5, 5)
                      .filter(t -> t > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(joining(", ", "[", "]"))
        );

        System.out.println(
            Stream.of(1, 2, 3, 5, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .distinct()
                  .collect(joining(", ", "[", "]"))
        );
        System.out.println(
            Stream.of(1, 2, 3, 5, 5)
                  .filter(t -> t > 2)
                  .map(i -> i * 2)
                  .map(i -> "#" + i)
                  .distinct()
                  .collect(toList())
        );
        System.out.println(
                Stream.of(1, 2, 3, 5, 5)
                      .filter(t -> t > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .distinct()
                      .collect(toList())
        );


        final Integer integer3 = 3;
        System.out.println(
            Stream.of(1, 2, 3, 4, 5)  //Integer.valueOf(x), IntergerCache..
                  .filter(i -> i == integer3)
                  .findFirst()
        );



        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 127)
                      .filter(i -> i == integer127)
                      .findFirst()
        );

        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                      .filter(i -> i == integer128)
                      .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                      .filter(i -> i.equals(integer128))
                      .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                      .filter(i -> i.equals(integer128))
                      .count()
        );
    }
}
