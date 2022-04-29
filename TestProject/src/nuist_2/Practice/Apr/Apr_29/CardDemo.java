package nuist_2.Practice.Apr.Apr_29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Eliot
 */
public class CardDemo {

    public static List<Card> allCards =new ArrayList<>();

    static{
        String[] sizes={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors={"♥","♠","♦","♣"};
        int i;
        for (i = 0; i < sizes.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                Card c=new Card(sizes[i],colors[j],i);
                allCards.add(c);
            }
        }
        allCards.add(new Card("","☺",i++));
        allCards.add(new Card("","☹",i));
    }

    public static void main(String[] args) {
        Collections.shuffle(allCards);

        List<Card> player1=new ArrayList<>();
        List<Card> player2=new ArrayList<>();
        List<Card> player3 =new ArrayList<>();
        List<Card> hideCard =new ArrayList<>();

        for(int i=0;i<allCards.size()-3;i++){
            if(i%3==0){
                player1.add(allCards.get(i));
            }else if(i%3==1){
                player2.add(allCards.get(i));
            }else{
                player3.add(allCards.get(i));
            }
        }
        hideCard.addAll(allCards.subList(allCards.size()-3,allCards.size()));

        sortList(player1);
        sortList(player2);
        sortList(player3);
        sortList(hideCard);

        System.out.println("player1："+player1);
        System.out.println("player2："+player2);
        System.out.println("player3："+player3);
        System.out.println("底牌："+hideCard);
    }

    public static void sortList(List<Card> list){
        Collections.sort(list,(Card o1, Card o2)-> o2.getIndex()-o1.getIndex());
    }
}
