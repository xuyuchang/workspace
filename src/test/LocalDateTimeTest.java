package test;

import java.time.LocalDateTime;

/**
 * @author Mr.xu
 * @create 2022/03/17/12:15
 * Description:
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime time1 = LocalDateTime.of(2022, 3, 17, 12, 22, 22);
        System.out.println(time1);
        LocalDateTime time2 = time1.withDayOfMonth(2);
        System.out.println(time2.getDayOfMonth());
        System.out.println(time1.plusHours(5));
        LocalDateTime time3 = time1.minusDays(2);
        System.out.println(time3);


    }






}


