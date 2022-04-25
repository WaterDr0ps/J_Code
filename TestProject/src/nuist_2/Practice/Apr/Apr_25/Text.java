package nuist_2.Practice.Apr.Apr_25;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(print(arr));
    }
    public static String print(int[] arr){
        if(arr!=null){
            StringBuilder sb=new StringBuilder("[");
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append(i==arr.length-1?"":",");
            }
            sb.append("]");
            return sb.toString();
        }else{
            return null;
        }
    }
}
