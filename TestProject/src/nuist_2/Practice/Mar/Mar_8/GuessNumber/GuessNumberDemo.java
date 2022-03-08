package nuist_2.Practice.Mar.Mar_8.GuessNumber;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GuessNumberDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("D:\\name.txt");
        Properties prop=new Properties();
        prop.load(fr);

    }
}
