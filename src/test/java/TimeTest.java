import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        String beginTime="2020-02-09";
        String pattern="([0-9]{4})-[0-9]{2}-[0-9]{2}";
        boolean matches = beginTime.matches(pattern);
        System.out.println("matches:"+matches);



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()).toString());
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
    }
}
