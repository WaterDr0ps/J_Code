package nuist_2.Practice.Mar.Mar_1.DouDiZhu;

import java.util.*;

public class DouDiZhu_up {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        String[] colors={"♦","♣","♥","♠"};
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        int index=0;
        for(String color:colors){
            for(String number:numbers){
                map.put(index, color+number);
                list.add(index);
                index++;
            }
        }
        map.put(index, "小王");
        list.add(index);
        index++;
        map.put(index, "大王");
        list.add(index);

        Collections.shuffle(list);

        Set<Integer> player1=new TreeSet<>();
        Set<Integer> player2=new TreeSet<>();
        Set<Integer> player3=new TreeSet<>();
        Set<Integer> hideCard=new TreeSet<>();

        for(int i=0;i<list.size();i++){
            if(i<list.size()-3){
                switch (i%3){
                    case 0:
                        player1.add(list.get(i));
                        break;
                    case 1:
                        player2.add(list.get(i));
                        break;
                    default:
                        player3.add(list.get(i));
                }
            }else{
                hideCard.add(list.get(i));
            }
        }
        lookHideCard("player1", map, player1);
        lookHideCard("player2", map, player2);
        lookHideCard("player3", map, player3);
        lookHideCard("hideCard", map, hideCard);

    }

    public static void lookHideCard(String name,Map<Integer,String> map,Set<Integer> set){
        System.out.print(name+"的牌是:");
        for(Integer key:set){
            String value=map.get(key);
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
