package instant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class ZoneDateTimeTest {

    @Test
    public void test(){
        ZonedDateTime nowSeoul = ZonedDateTime.now();
        System.out.println("Now in Seoul is " + nowSeoul);

        ZonedDateTime nowLa = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Now in LA is " + nowLa);

        ZonedDateTime worldCup = ZonedDateTime.of(2002, 6, 18, 20, 30,  0, 0, ZoneId.of("Asia/Seoul"));
        System.out.println("World Cup is " + worldCup);
    }

    @Test
    public void test2(){
        ZonedDateTime worldCup = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("World Cup is " + worldCup);
    }

    @Test
    public void localDateTime(){
        LocalDate date = LocalDate.of(2002, 6, 13);
        System.out.println("Date " + date);

        LocalTime time = LocalTime.of(20, 30);
        System.out.println("Time: " + time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println("DateTime: " + dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        System.out.println("DateTime: " + zonedDateTime.toLocalDateTime());
        System.out.println("Date: " + zonedDateTime.toLocalDate());
        System.out.println("Time: " + zonedDateTime.toLocalTime());

    }
}
