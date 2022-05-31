package nuist_2.Practice.May.May_31;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        File f = new File("D:\\www");
        read(f);
        write(new File("D:\\www\\input.txt"),new File("D:\\www\\output.txt"));
    }
    public static void read(File file) {
        File[] fi = file.listFiles();
        if (fi!=null) {
            for(File f:fi) {
                if(f.isDirectory()) {
                    read(f);
                }else {
                    System.out.println(f.getName());
                }
            }
        } else {
            System.out.println("空路径");
        }
    }

    public static void write(File srcFile, File targetFile){
        try(
                Reader fr=new FileReader(srcFile);
                BufferedReader br=new BufferedReader(fr);

                Writer fw=new FileWriter(targetFile);
                BufferedWriter bw=new BufferedWriter(fw);
                ){
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
            }
        }catch (IOException o){
            o.printStackTrace();
        }
    }
}
