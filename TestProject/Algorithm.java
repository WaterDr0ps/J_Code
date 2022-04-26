package TestProject;

/**
 * @author Eliot
 */
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

        //二分查找
        /*
        int[] arr = {2, 7, 12, 25, 28, 30, 46};
        System.out.println(binarySearch(arr, 28));
         */
    }
    //二分查找
    /*
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid=(left+right)/2;
            if(value>arr[mid]){
                left=mid+1;
            }else if(value<arr[mid]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
     */
}
