package nuist_2.Practice.Mar.Mar_1.DouDiZhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DouDiZhu {
    public static void main(String[] args) {
        //模拟斗地主：用ArrayList集合创建牌盒——>装牌——>洗牌Collections.shuffle()——>发牌(遍历集合，给三人发牌)——>看牌(三人分别遍历)
        List<String> list=new ArrayList<>();
        String[] color={"♠","♥","♦","♣"};
        String[] number={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(String c:color){
            for(String n:number){
                list.add(c+n);
            }
        }
        list.add("小王");
        list.add("大王");
        Collections.shuffle(list);
        List<String> player1=new ArrayList<>();
        List<String> player2=new ArrayList<>();
        List<String> player3=new ArrayList<>();
        List<String> hideCard=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i< list.size()-3){
                switch (i%3){
                    case 0:
                        player1.add(list.get(i));
                        break;
                    case 1:
                        player2.add(list.get(i));
                        break;
                    default:
                        player3.add(list.get(i));
                        break;
                }
            }else{
                hideCard.add(list.get(i));
            }

        }
        lookHideCard("player1", player1);
        lookHideCard("player2", player2);
        lookHideCard("player3", player3);
        lookHideCard("底牌", hideCard);
    }

    public static void lookHideCard(String name,List<String> player){
        System.out.print(name+":");
        for(String s:player){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
