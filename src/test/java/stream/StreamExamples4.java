package stream;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

public class StreamExamples4 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
              .collect(toList());

        Stream.of(1, 2, 3, 4, 5)
              .collect(toSet());

        String collect = Stream.of(1, 2, 3, 4, 5)
                               .map(i -> String.valueOf(i))
                               .collect(joining(" "));
        System.out.println(collect);
    }
}
