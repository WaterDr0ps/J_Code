package nuist_2.Practice.Mar.Mar_17.TCPtext2;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("10.33.4.195",10003);

        BufferedReader br=new BufferedReader(new FileReader("D:\\name.txt"));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();

        BufferedReader brClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("message："+brClient.readLine());

        s.close();
        br.close();
    }
}
