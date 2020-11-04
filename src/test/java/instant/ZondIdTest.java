package instant;

import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.junit.Test;

public class ZondIdTest {

    @Test
    public void zoneId(){
        ZoneOffset seoulZoneOffset = ZoneOffset.of("+09:00");
        System.out.println("+09:00 Time: " + ZonedDateTime.now(seoulZoneOffset));

        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        System.out.println("Seoul Time : " + ZonedDateTime.now(seoulZoneId));
    }


    @Test
    public void zoneOffset(){
        ZoneOffset vancouverZoneOffset = ZoneOffset.of("-08:00");
        System.out.println("-08:00 time : " + ZonedDateTime.now(vancouverZoneOffset));

        ZoneId vancouverZoneId = ZoneId.of("America/Vancouver");
        System.out.println("Vancouver time : " + ZonedDateTime.now(vancouverZoneId));
    }

    @Test
    public void withZoneSameInstant(){
        ZonedDateTime seoul = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("Seoul: " + seoul);

        ZonedDateTime utc = seoul.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println("UTC: " + utc);

        ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("London: " + london);

        ZonedDateTime newYork = seoul.withZoneSameInstant(ZoneOffset.of("-0400"));
        System.out.println("newYork: " + newYork);

        ZonedDateTime vancouver = seoul.withZoneSameInstant(ZoneId.of("America/Vancouver"));
        System.out.println("vancouver: " + vancouver);
    }

    @Test
    public void stringtest(){
        ZonedDateTime worldCup = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));

        System.out.println(worldCup.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(worldCup.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")));
        System.out.println(worldCup.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println(worldCup.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(
                Locale.KOREA)));

        ZonedDateTime zdt1 = ZonedDateTime.parse("2002-06-18T20:30:00+09:00[Asia/Seoul]");
        ZonedDateTime zdt2 = ZonedDateTime.parse("2002/06/18 20:30:00 KST", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss z"));
        System.out.println("zdt1: " + zdt1);
        System.out.println("zdt2: " + zdt2);

        ZonedDateTime zdt3 = ZonedDateTime.parse("Tuesday, June 18, 2002 8:30:00 PM KST", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        ZonedDateTime zdt4 = ZonedDateTime.parse("2002년 6월 18일 화요일 오후 8시 30분 00초 KST", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.KOREA));
        System.out.println("zdt3: " + zdt3);
        System.out.println("zdt4: " + zdt4);

    }
}
