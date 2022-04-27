package nuist_2.Practice.Apr.Apr_27;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        String[] arr={"张三","李四"};
        myPrint(arr);

        Integer[] arr1={1,2,3,4};
        myPrint(arr1);

        String[] arr2={};
        myPrint(arr2);
    }

    private static <E> void myPrint(E[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(i==arr.length-1?"":", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
