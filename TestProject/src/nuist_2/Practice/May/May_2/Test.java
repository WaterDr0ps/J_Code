package nuist_2.Practice.May.May_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        String date="2019-10-2 12:00:00";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(date);
        System.out.println(parse);
    }
}
