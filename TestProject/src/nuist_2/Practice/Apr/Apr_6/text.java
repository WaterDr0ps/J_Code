package nuist_2.Practice.Apr.Apr_6;

public class text {
    public static void main(String[] args) {
        int[] arr={20,40,30,25,15,2,3,9,80,46,55};
        for(int i=0;i<arr.length;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[index];  
            arr[index]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
