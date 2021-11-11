package Practice;

import java.util.Scanner;

public class Method {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        if(judgePassWord(input)){
            System.out.println("正确");
        }
    }

    //判断密码
    public static boolean judgePassWord(String input){
        if(input.equals("abcde")){
            return true;
        }else{
            return false;
        }
    }
    //冒泡排序
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index == i) {
                continue;
            } else {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    //强制类型转换
    public static void intToChar(int x) {
        System.out.println((char) x);
    }

    //翻转数组元素
    public static void arrInvert(int arr[]) {
        for (int i = 0; i <= (arr.length - 1) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        printArray(arr);
    }

    //判断数组元素是否相等
    public static boolean arrCompareEqual(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    //斐波那契数列
    public static int fibonacci(int x) {
        int[] arr = new int[x];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < x; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[x - 1];
    }

    //逢七过
    public static void pass7() {
        int i;
        for (i = 1; i <= 100; i++) {
            if (i % 7 == 0 || i / 10 == 7 || i % 10 == 7) {
                System.out.println(i + " ");
            }
        }
    }

    //switch练习
    public static void loseWeightPlan(int week) {
        switch (week) {
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
    public static int getArrayMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    //数组遍历
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    //创建数组
    public static void initArray(int arr[], int x) {
        System.out.println("请给组数赋" + x + "个值");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
    }

    //方法重载
    public static void GetMax(int x, int y) {
        int max = x > y ? x : y;
        System.out.println(max + "大");
    }

    //方法重载
    public static void GetMax(int x, int y, int z) {
        int max = x > y ? x > z ? x : z : y > z ? y : z;
        System.out.println(max + "大");
    }
}

