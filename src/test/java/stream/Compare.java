package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class Compare {

    final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
    Comparator<Person> compareDescending = (person1, person2) -> person2.ageDifference(person1);

    @Test
    public void ascending(){
        List<Person> ascendingAge = people.stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(toList());

        printPeople("Sorted in ascending order by age:" , ascendingAge);
    }



    @Test
    public void descending(){
        List<Person> ascendingAge = people.stream()
                .sorted((person1, person2) -> person2.ageDifference(person1))
                .collect(toList());

        printPeople("Sorted in ascending order by age:" , ascendingAge);
    }

    @Test
    public void ascending_2(){
        printPeople("Sorted in ascending order by age:" , people.stream()
                .sorted(compareAscending).collect(toList()));
    }

    @Test
    public void descending_2(){
        printPeople("Sorted in ascending order by age:" , people.stream()
                .sorted(compareDescending).collect(toList()));
    }

    @Test
    public void ascending_first(){
      people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("yougest:" + youngest));
    }

    @Test
    public void nameAceding(){

        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byName = person -> person.getName();

        printPeople("Sorted in asceding order by age and name:", people.stream().sorted(comparing(byAge).thenComparing(byName)).collect(toList()));

    }

    public static void printPeople(final String message, final List<Person> people){
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
