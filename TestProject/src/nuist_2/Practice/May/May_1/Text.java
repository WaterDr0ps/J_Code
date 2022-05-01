package nuist_2.Practice.May.May_1;

import java.util.*;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        Map<String, List<String>> data=new HashMap<>(16);
        List<String> place=new ArrayList<>();
        Collections.addAll(place, "A","B");
        data.put("张三",place);

        List<String> place2=new ArrayList<>();
        Collections.addAll(place2,"A","B","C");
        data.put("李四",place2);

        List<String> place3=new ArrayList<>();
        Collections.addAll(place3,"A","B","C","D");
        data.put("王五",place3);

        System.out.println(data);
        
        Map<String,Integer> infos=new HashMap<>(16);
        Collection<List<String>> values=data.values();

        for (List<String> value : values) {
            for (String s : value) {
                if(infos.containsKey(s)){
                    infos.put(s,infos.get(s)+1);
                }else{
                    infos.put(s,1);
                }
            }
        }

        System.out.println(infos);

    }
}
