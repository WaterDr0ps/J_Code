package nuist_2.Practice.Mar.Mar_17.TCPtext2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10003);
        Socket s=ss.accept();

        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\copy.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功！");
        bwServer.newLine();
        bwServer.flush();

        ss.close();
        bw.close();
    }
}
