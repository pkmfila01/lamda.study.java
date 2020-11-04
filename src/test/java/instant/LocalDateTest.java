package instant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;

import org.junit.Test;

public class LocalDateTest {

    @Test
    public void test(){
        LocalDate today = LocalDate.now();
        System.out.println("Today is " + today);

        LocalDate birthday = LocalDate.of(1982, 7, 13);
        System.out.println("My birthday is " + birthday);

        LocalDate christmas = LocalDate.parse("2017-12-25");
        System.out.println("Last Christmas is " + christmas);
    }

    @Test
    public void localTime(){
        LocalTime currentTime = LocalTime.now();
        System.out.println("The current time here is " + currentTime);

        LocalTime currentTimeInParis = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("The current time in Paris is " + currentTimeInParis);

        LocalTime currentTimeChicago = LocalTime.now(ZoneId.of("America/Chicago"));
        System.out.println("The current time in Chicago is " + currentTimeChicago);

        LocalTime timeToGoBed = LocalTime.of(23, 30, 0);
        System.out.println("I go to bed at " + timeToGoBed);

        LocalTime timeToGetUp = timeToGoBed.plusHours(8);
        System.out.println("I get up at " + timeToGetUp);

        System.out.println("I still go to bed at " + timeToGoBed);

    }

    @Test
    public void localDateTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now is " + now);

        LocalDateTime now2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Now is " + now2);

        LocalDateTime y2k = LocalDateTime.parse("1999-12-31T23:59:59.999");
        System.out.println("Y2K is " + y2k);

        LocalDateTime dateOfBirth = LocalDateTime.of(1982, 7, 13, 14, 25, 00);
        System.out.println("My date of birth is " + dateOfBirth);

        LocalDateTime dateOfBirth2 = Year.of(1982).atMonth(7).atDay(14).atTime(14, 25);
        System.out.println("My date of birth is " + dateOfBirth2);
    }

    @Test
    public void util(){
        LocalDate today = Year.of(2020).atMonth(11).atDay(4);
        System.out.println("Today : " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("DayOfMonth: " + today.getDayOfMonth());
        System.out.println("DayOfWeek: " + today.getDayOfWeek());
        System.out.println("IsLeapYear: " + today.isLeapYear());

        System.out.println("1 year after today : " + today.plusYears(1));
        System.out.println("1 momth after today : " + today.plusMonths(1));
        System.out.println("1 day after today : " + today.plusDays(1));

        LocalDateTime now = today.atTime(22,46, 17, 348);
        System.out.println("Now : " + now);
        System.out.println("Hour : " + now.getHour());
        System.out.println("Minute : " + now.getMinute());
        System.out.println("Second : " + now.getSecond());
        System.out.println("Nano : " + now.getNano());
    }
}
