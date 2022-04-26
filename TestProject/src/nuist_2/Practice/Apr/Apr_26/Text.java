package nuist_2.Practice.Apr.Apr_26;

import java.util.Scanner;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        while(true){
            checkMoney();
        }
    }
    public static void checkMoney(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入金额：");
        String money=sc.next();
        if(money!=null && money.matches("0?\\d{0,9}\\.?[0-9]")){
            System.out.println("金额输入正确");
        }else{
            System.out.println("金额输入错误");
        }
    }
}
