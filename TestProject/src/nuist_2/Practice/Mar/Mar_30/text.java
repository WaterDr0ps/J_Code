package nuist_2.Practice.Mar.Mar_30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class text {
    public static void main(String[] args) {
//        String[] str={"张三,30","李四,40","王大彪,26","赵本山,10"};
//        ArrayList<String> list = myFilter(str, s -> s.split(",")[0].length() > 2, s -> Integer.parseInt(s.split(",")[1]) > 20);
//        for(String s:list){
//            System.out.println(s);
//        }

//        List<String> list=new ArrayList<>();
//        list.add("张三");
//        list.add("李四");
//        list.add("张飞");
//        list.add("李大彪");
//        list.stream().filter(s->s.startsWith("李")).filter(s->s.length()>2).forEach(System.out::println);

        List<String> list=new ArrayList<>();
        list.add("张三");
        list.add("张三丰");
        list.add("李四");
        list.add("王虎");
        list.add("李大彪");
        List<String> name = list.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());
        for(String s:name){
            System.out.println(s);
        }

        Set<Integer> set=new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        Stream<Integer> setStream = set.stream().filter(s -> s > 20);
        Set<Integer> collect = setStream.collect(Collectors.toSet()) ;
    }
    private static ArrayList<String> myFilter(String[] str, Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> list=new ArrayList<>();
        for(String s:str){
            if(pre1.and(pre2).test(s)){
                list.add(s);
            }
        }
        return list;
    }
}
