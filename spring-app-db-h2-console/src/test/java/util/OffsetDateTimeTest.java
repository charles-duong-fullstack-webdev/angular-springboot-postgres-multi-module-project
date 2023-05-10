package util;

//import org.junit.Test;
//
//import java.time.OffsetDateTime;
//import java.util.Date;
//
//import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class OffsetDateTimeTest {

    @Test
    public void createOffsetDateTime() {
        long now = System.currentTimeMillis();
        long nowPlus_1sec = now + 1000L;

        OffsetDateTime d1 = OffsetDateTime.now();

        OffsetDateTime offset = OffsetDateTime.now();
        OffsetDateTime d2 =  offset.minusSeconds(nowPlus_1sec);

        assertTrue(d1.compareTo(d2) > 0);
        //assertEquals(d1.getHour(), d2.getHour());
        assertNotEquals(d1.getSecond(), d2.getSecond());

//        if (d1.getSecond() == 59) {
//            assertEquals(d2.getSecond(), 0);
//        } else {
//            assertEquals(d1.getSecond() + 1, d2.getSecond());
//        }
    }

    @Test
    public void createTimestamp() {
        long now = System.currentTimeMillis();

        String dateTimeStr = "2020-05-01T00:00:00+05:00";
        OffsetDateTime odt = OffsetDateTime.parse(dateTimeStr);

        // Get LocalDateTime from the given date-time string (which is with the offset
        // as +05:00 hours)
        LocalDateTime ldt1 = odt.toLocalDateTime();
        System.out.println("ldt1: "+ldt1);

        // Get LocalDateTime in GMT (which is with the offset as +01:00 hours)
        // corresponding to the given date-time string
        LocalDateTime ldt2 = LocalDateTime.ofInstant(odt.toInstant(), ZoneId.of("Europe/London"));
        System.out.println("ldt22: "+ldt2);

        // Print offset of the given date-time string and that of GMT
        System.out.println(odt.getOffset());
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/London")).getOffset());

        OffsetDateTime d1 =  OffsetDateTime.now();
        System.out.println("d1: "+d1);


//        long result = OffsetDateTime.createTimestamp(d1);
//
//
//        assertEquals(result, now);


    }
}
