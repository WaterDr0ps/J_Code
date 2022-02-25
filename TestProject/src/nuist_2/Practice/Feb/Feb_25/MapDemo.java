package nuist_2.Practice.Feb.Feb_25;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        //Map遍历
        Map<String,String> map=new HashMap<>();
        map.put("张三", "李四");
        map.put("王五", "李六");
        //获取键
        Set<String> set=map.keySet();
        for(String s:set){
            System.out.println(s);
        }
        //获取值
        Collection<String> col=map.values();
        for(String s:col){
            System.out.println(s);
        }

        //第一种
        for(String s:set){
            String value=map.get(s);
            System.out.println(s+","+value);
        }
        //第二种
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        for(Map.Entry<String,String> entry:entrySet){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
