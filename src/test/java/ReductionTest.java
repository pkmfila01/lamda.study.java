import org.junit.Test;

import java.io.CharArrayReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReductionTest {
    List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    @Test
    public void reduction(){
        System.out.println(
                friends.stream().map(String::toUpperCase).collect(Collectors.joining(", "))
        );
    }

    final String str = "w00t";
    @Test
    public void stringIterator(){
        str.chars().forEach(ch -> System.out.println(ch));

        str.chars().forEach(System.out::println);

        str.chars().forEach(IterateString::printChar);

        str.chars().mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);

    }

    public static class IterateString{
        private static void printChar(int aChar){
            System.out.println((char)(aChar));
        }
    }
}
