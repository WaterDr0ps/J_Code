package nuist_2.Practice.Mar.Mar_19.classQuote;

public class ConvertDemo {
    public static void main(String[] args) {
        useConvert(s->Integer.parseInt(s));

        useConvert(Integer::parseInt);
    }
    private static void useConvert(Convertable s){
        int num = s.convert("666");
        System.out.println(num);
    }
}
