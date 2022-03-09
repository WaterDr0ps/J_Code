package nuist_2.Practice.Mar.Mar_8.GuessNumber;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class GuessNumberDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("D:\\name.txt");
        Properties prop=new Properties();
        prop.load(fr);
        fr.close();

        String count=prop.getProperty("count");
        int number=Integer.parseInt(count);

        if(number>=3){
            System.out.println("免费试玩结束了");
        }else{
            GuessNumber.guess();
            number++;
            prop.setProperty("count", String.valueOf(number));
            FileWriter fw=new FileWriter("D:\\name.txt");
            prop.store(fw, null);
            fw.close();
        }

    }
}
