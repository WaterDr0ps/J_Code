import java.util.Scanner;

public class Method {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入星期几:");
        int week=sc.nextInt();
        while(true){
            if (week < 1||week>7) {
                System.out.println("输入有误请重新输入");
                week=sc.nextInt();
            }else{
                loseWeightPlan(week);
                break;
            }
        }
    }
    //switch练习
    public static void loseWeightPlan(int week){
        switch(week){
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("散步");
                break;
            case 3:
                System.out.println("游泳");
                break;
            case 4:
                System.out.println("健身");
                break;
            case 5:
                System.out.println("篮球");
                break;
            case 6:
                System.out.println("休息");
                break;
            default:
                System.out.println("吃顿好的");
        }
    }
    //求数组最大值
    public static int getArrayMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    //数组遍历
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.print(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
    //方法重载
    public static void GetMax(int x,int y){
        int max=x>y?x:y;
        System.out.println(max+"大");
    }
    //方法重载
    public static void GetMax(int x,int y,int z){
        int max=x>y?x>z?x:z:y>z?y:z;
        System.out.println(max+"大");
    }
}

