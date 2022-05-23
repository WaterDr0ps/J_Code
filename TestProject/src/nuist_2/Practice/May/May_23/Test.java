package nuist_2.Practice.May.May_23;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name="abc你好";
        byte[] bytes = name.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        String s=new String(bytes,"GBK");
        System.out.println(s);
    }
}
