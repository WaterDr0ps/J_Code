package Homework.work_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        final String NAME="NUIST";
        Scanner sc=new Scanner(System.in);
        List<Person> list=new ArrayList<>();
        Person[] student=new Student[100];
        Person[] teacher=new Teacher[100];
        int s=0;
        int t=0;
        while(true){
            System.out.println("1.注册 2.开除 3.查同名 4.老师工资总和 其他.退出");
            int x=sc.nextInt();
            switch (x){
                case 1:
                    while(true){
                        System.out.println("1.注册学生 2.注册老师 其他.退出");
                        int index=sc.nextInt();
                        if(index==1){
                            register(student[s++],index);
                        }else if(index==2){
                            register(teacher[t++],index);
                        }else{
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入要开除的姓名");
                case 3:
                case 4:
                default:
                    return;
            }
        }
    }

    public static Person register(Person person,int x){
        Scanner sc=new Scanner(System.in);
            switch (x){
                case 1:
                    System.out.println("请输入学生姓名、年龄、学号、专业");
                    person=new Student(sc.next(),sc.nextInt(),sc.next(),sc.next());
                    break;
                case 2:
                    System.out.println("请输入老师姓名、年龄、工号、薪资");
                    person=new Teacher(sc.next(),sc.nextInt(),sc.next(),sc.nextInt());
                    break;
                default:
                    break;
        }

        return person;
    }

    public static void fire(Person person,List<Person> list){
        for(int i=0;i< list.size();i++){
            if(list.get(i).equals(person)){
                list.remove(i);
            }
        }
    }

    public static List<Person> searchPerson(String name,List<Person> list){
        List<Person> repeat=new ArrayList<>();
        for(int i=0;i< list.size();i++){
            if(list.get(i).getName().equals(name)){
                repeat.add(list.get(i));
            }
        }
        return repeat;
    }

    public static double getTotalSalary(Teacher[] teacher){
        double count=0;
        for(int i=0;i< teacher.length;i++){
            count+=teacher[i].getSalary();
        }
        return count;
    }
}
