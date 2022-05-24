package nuist_2.Practice.May.May_23;

import java.io.*;
import java.util.Arrays;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        String name="abc你好";
//        byte[] bytes = name.getBytes("GBK");
//        System.out.println(bytes.length);
//        System.out.println(Arrays.toString(bytes));
//
//        String s=new String(bytes,"GBK");
//        System.out.println(s);

//        InputStream is=new FileInputStream("TestProject/src/data.txt");
//        byte[] bytes = new byte[3];
//        int len;
//        while((len=is.read(bytes))!=-1){
//            System.out.print(new String(bytes,0,len));
//        }

//        File f=new File("TestProject/src/data.txt");
//        InputStream is=new FileInputStream(f);
//        byte[] buffer=new byte[(int) f.length()];
//        int len=is.read(buffer);
//        System.out.println(new String(buffer,0,len));

//        File f=new File("TestProject/src/data.txt");
//        InputStream is=new FileInputStream(f);
//        OutputStream os=new FileOutputStream("TestProject/src/dataCopy.txt");
//        try {
//            byte[] buffers=new byte[(int) f.length()];
//            int len=is.read(buffers);
//
//            os.write(buffers,0,len);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            os.flush();
//            os.close();
//        }

        try (
                Reader fr=new FileReader("TestProject/src/data.txt");
        ){
            char[] chars=new char[5];
            int len;
            while((len=fr.read(chars))!=-1){
                System.out.print(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
