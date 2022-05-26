package nuist_2.Practice.May.May_25;

import java.io.*;
import java.util.*;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) {
        try (
                Reader fr=new FileReader("TestProject/src/data.txt");
                BufferedReader br=new BufferedReader(fr);

                Writer fw=new FileWriter("TestProject/src/dataCopy.txt");
                BufferedWriter bw=new BufferedWriter(fw);
                ){
            List<String> data=new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
            }

            List<String> sizes=new ArrayList<>();
            Collections.addAll(sizes,"一","二","三","四","五","六","十一");
            Collections.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return sizes.indexOf(o1.substring(0,o1.indexOf(".")))
                            -sizes.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });

//            Map<String,Integer> sizes=new TreeMap<>();
//            sizes.put("一",1);
//            sizes.put("二",2);
//            sizes.put("三",3);
//            sizes.put("四",4);
//            sizes.put("五",5);
//            sizes.put("六",6);
//            sizes.put("十一",11);
//            Collections.sort(data,new Comparator<String>(){
//                @Override
//                public int compare(String o1, String o2) {
//                    return sizes.get(o1.substring(0,o1.indexOf(".")))
//                            -sizes.get(o2.substring(0,o2.indexOf(".")));
//                }
//            });


            for (String s : data) {
                bw.write(s+"\r\n");
            }
            
        }catch (IOException o){
            o.printStackTrace();
        }
    }
}
