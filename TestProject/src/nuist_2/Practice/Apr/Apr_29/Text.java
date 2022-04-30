package nuist_2.Practice.Apr.Apr_29;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author Administrator
 */
public class Text {
    public static void main(String[] args) {
        //统计投票人数
        char[] place={'A','B','C','D'};
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append(place[r.nextInt(place.length)]);
        }
        System.out.println(sb);

        Map<Character,Integer> map=new HashMap<>(16);
        int index=0;
        for (int i = 0; i < sb.length(); i++) {
            char ch=sb.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }

        //遍历Map集合
        Set<Character> keySet = map.keySet();
        for(Character key:keySet){
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }
    }
}
