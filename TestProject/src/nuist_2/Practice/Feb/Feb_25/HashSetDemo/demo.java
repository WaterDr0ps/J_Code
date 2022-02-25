package nuist_2.Practice.Feb.Feb_25.HashSetDemo;

import java.util.HashSet;
import java.util.Set;

public class demo {
    public static void main(String[] args) {
        Set<Student> s=new HashSet<>();
        Student s1=new Student("张三",20);
        Student s2=new Student("李四",21);
        Student s3=new Student("李四",21);
        s.add(s1);
        s.add(s2);
        s.add(s3);
        for(Student stu:s){
            System.out.println(stu.getName()+","+stu.getAge());
        }
    }
}
