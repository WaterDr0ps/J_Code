package nuist_2.Practice.Mar.Mar_21.ClassQuote;

public class MyStringDemo {
    public static void main(String[] args) {
        useMyString((s,x,y)->s.substring(x,y));

        useMyString(String::substring);
    }
    private static void useMyString(MyString m){
        String s = m.mySubString("HelloWorld", 0, 3);
        System.out.println(s);
    }
}
