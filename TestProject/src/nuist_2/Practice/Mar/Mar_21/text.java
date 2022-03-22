package nuist_2.Practice.Mar.Mar_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class text {
    public static void main(String[] args) {
//        startThread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"线程启动");
//            }
//        });
//        startThread(()-> System.out.println(Thread.currentThread().getName()+"线程启动"));

//        List<String> list = new ArrayList<>();
//        list.add("cc");
//        list.add("ddd");
//        list.add("bbbb");
//        list.add("a");
//        System.out.println("排序前:"+list);
//        Collections.sort(list,getComparator());
//        System.out.println("排序后:"+list);

//        int[] arr={20,50,34,21,26};
//        int maxValue = getMax(() -> {
//            int max = arr[0];
//            for (int i = 1; i < arr.length; i++) {
//                if (arr[i] > max) {
//                    max = arr[i];
//                }
//            }
//            return max;
//        });
//        System.out.println(maxValue);

        String[] arr={"张三,20","李四,14","王五,36"};
        printInfo(arr, s->{
            String name=s.split(", ")[0];
            System.out.print("姓名:"+name);
        },s->{
            int age=Integer.parseInt(s.split(",")[1]);
            System.out.println("年龄:"+age);
        });

    }

    private static void printInfo(String[] arr, Consumer<String> c1,Consumer<String> c2){
        for(String s:arr){
            c1.andThen(c2).accept(s);
        }
    }

    private static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    private static Comparator<String> getComparator(){
//        Comparator<String> comp=new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
//        return comp;
        return (s1,s2)->s1.length()-s2.length();
    }

    private static void startThread(Runnable r){
        new Thread(r).start();
    }
}
