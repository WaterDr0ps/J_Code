package nuist_2.Practice.May.May_24;

import java.io.*;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) {
        try(
                InputStream is=new FileInputStream("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\1.jpg");
                InputStream bis=new BufferedInputStream(is);

                OutputStream os=new FileOutputStream("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\1copy.jpg");
                OutputStream bos=new BufferedOutputStream(os);
                ){
            byte[] bytes=new byte[1024];
            int len;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        }catch (IOException o){
            o.printStackTrace();
        }
    }
}
