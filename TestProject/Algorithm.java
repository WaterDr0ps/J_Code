package TestProject;

public class Algorithm {
    public static void main(String[] args) {
        //选择排序
        /*
        int[] arr={20,40,30,25,15,2,3,9,80,46};
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
         */

        //插入排序
        /*
        int[] arr={20,32,12,4,68,9,16,46,58,6};
        int j;
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            for(j=i-1;j>=0&&arr[j]>temp;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
         */

        //
    }
}
