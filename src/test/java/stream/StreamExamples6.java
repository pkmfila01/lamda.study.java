package stream;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class StreamExamples6 {
    public static void main(String[] args) {
        final int[] sum = {0};
        Arrays.asList(1, 2, 3, 4, 5)
              .forEach(value -> sum[0] += value);
        System.out.println( "total: " + sum[0]);

        System.out.println("\n=============================");
        final long start5 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4,5, 6, 7,8 )
              .parallelStream()
              .map(i -> {
                  try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  return i;
              })
              .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start5);


        System.out.println("\n==========no parrallelStream===================");
        final long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7,8 )
              .stream()
              .map(i -> {
                  try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  return i;
              })
              .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start4);


        System.out.println("\n==========parrallelStream===================");
        System.out.println("Parallel Stream(8 elements) with parallelism: 0");
        System.setProperty("java.util.concurrent.forkJoinPool.common.parallelism", "0");
        final long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7,8 )
              .stream()
              .map(i -> {
                  try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  return i;
              })
              .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start3);
    }
}
