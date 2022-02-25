package nuist_2.Practice.Feb.Feb_25.TreeSetDemo;

import java.util.Comparator;
import java.util.TreeSet;

public class demo {
    public static void main(String[] args) {
        Student s1=new Student("张三",89,97);
        Student s2=new Student("李四",88,65);
        Student s3=new Student("王五",88,65);
        TreeSet<Student> ts=new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num=s2.getSum()-s1.getSum();
                int num2=num==0?s2.getMath()-s1.getMath():num;
                int num3=num2==0?s2.getName().compareTo(s1.getName()):num2;
                return num3;
            }
        });
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        for(Student s:ts){
            System.out.println(s.toString());
        }
    }
}
