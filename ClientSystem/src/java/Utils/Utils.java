package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
    public static Date convertDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date);
        } catch(ParseException e) {}
        return null;
    }
    
    public static String convertDateFromString(Date d) {
        return new SimpleDateFormat("yyyy-MM-dd").format(d);
    }
    
    public static int compareDate(Date d1, Date d2) {
        Date today = truncate(d1);
        Date target = truncate(d2);
        if(today.equals(target)) {
            return 0;
        } else if(today.before(target)) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static Date truncate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)
        ).getTime();
    }
}
