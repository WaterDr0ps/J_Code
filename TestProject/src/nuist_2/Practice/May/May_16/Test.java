package nuist_2.Practice.May.May_16;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(recursion(1));
    }

    public static int recursion(int n){
        if(n==5){
            return 1;
        }else{
            return 2*recursion(n+1)+2;
        }
    }
}
