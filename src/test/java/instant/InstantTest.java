package instant;

import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class InstantTest {

    @Test
    public void test(){
        Instant epoch = Instant.EPOCH;
        System.out.println("epoch: " + epoch);

        Instant epochInFuture = Instant.ofEpochSecond(1_000_000_000);
        System.out.println("epochInFuter:" + epochInFuture);

        Instant epochInPast = Instant.ofEpochSecond(-1_000_000_000);
        System.out.println("epochInPast:" + epochInPast);

        Instant current = Instant.now();
        System.out.println("current:" + current);

        long epochSecond = current.getEpochSecond();
        System.out.println("epochSecond:" + epochSecond);

        long epochMilli = current.toEpochMilli();
        System.out.println("epochMill:" + epochMilli);
    }


    @Test
    public void zone(){
        ZonedDateTime zdtSeoul = Year.of(2020).atMonth(10).atDay(6).atTime(22, 06).atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zdtSeoul:" + zdtSeoul);

        Instant instant = zdtSeoul.toInstant();
        System.out.println("instant: " + instant + ", Timestamp:" + instant.getEpochSecond());

        ZonedDateTime zdtVancouver = instant.atZone(ZoneId.of("America/Vancouver"));
        System.out.println("Time in Vancouver:" + zdtVancouver);
    }

    @Test
    public void etc(){
        Instant worldCup = Instant.ofEpochSecond(1024399800);
        System.out.println("2002 World Cup:" + worldCup);
        System.out.println("10 seconds laster: " + worldCup.plusSeconds(10));
        System.out.println("10 seconds earlier: " + worldCup.minusSeconds(10));

        Instant now = Instant.now();
        System.out.println("Now: " + now);
        System.out.println("Is 2002 World Cup before now? " + worldCup.isBefore(now));
        System.out.println("Is 2002 World Cup after now?" + worldCup.isAfter(now));
    }
}
