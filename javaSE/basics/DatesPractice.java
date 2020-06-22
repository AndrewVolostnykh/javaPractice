package javaSE.basics;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class DatesPractice {
    public static void main()
    {
        System.out.println("Old dates(in standart type): " + oldDates("10/10/2010"));
        System.out.println("New dates: " + newDates("2010-10-10"));
    }

    private static Date oldDates(String a)
    {
        Date date = new Date();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            date = simpleDateFormat.parse(a);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println("Old dates in normal type: " + simpleDateFormat.format(calendar.getTime())); // we must write much code to out in type like dd/MM/yyyy
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }

    private static LocalDate newDates(String a)
    {
        LocalDate localDate;
        return localDate = LocalDate.parse(a);
    }
}
