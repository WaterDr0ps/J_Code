package nuist_1.Homework.work_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        final String NAME="NUIST";
        Scanner sc=new Scanner(System.in);
        List<Person> list=new ArrayList<>();
        Person person=new Person();
        boolean fireFlag=false;
        while(true){
            System.out.println("1.注册 2.开除 3.查同名 4.老师工资总和 5.查看所有信息 其他.退出");
            int x=sc.nextInt();
            switch (x){
                case 1:
                    list.add(register(person));
                    break;
                case 2:
                    Person p=fire(person);
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getName().equals(p.getName())){
                            list.remove(i);
                            fireFlag=true;
                            System.out.println("开除成功！");
                            break;
                        }
                    }
                    if(!fireFlag){
                        System.out.println("查无此人！");
                    }
                    break;
                case 3:
                    System.out.println("请输入姓名：");
                    String name=sc.next();
                    List<Person> repeat=searchPerson(name,list);
                    displayAll(repeat);
                    break;
                case 4:
                    System.out.println("老师总工资是："+getTotalSalary(list));
                    break;
                case 5:
                    displayAll(list);
                    break;
                default:
                    return;
            }
        }
    }

    public static Person register(Person person){
        System.out.println("1.注册学生 2.注册老师 其他.退出");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("请输入学生姓名、年龄、学号、专业");
                    person=new Student(sc.next(),sc.nextInt(),sc.next(),sc.next());
                    System.out.println("注册成功！");
                    return person;
                case 2:
                    System.out.println("请输入老师姓名、年龄、工号、薪资");
                    person=new Teacher(sc.next(),sc.nextInt(),sc.next(),sc.nextInt());
                    System.out.println("注册成功！");
                    return person;
                default:
                    break;
        }
        return person;
    }

    public static Person fire(Person person){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入要开除人的姓名：");
        String name=sc.nextLine();
        Person p=new Person(name,0);
        return p;
    }

    public static List<Person> searchPerson(String name,List<Person> list){
        List<Person> repeat=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                repeat.add(list.get(i));
            }
        }
        return repeat;
    }

    public static double getTotalSalary(List<Person> list){
        double count=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i) instanceof Teacher){
                count+=((Teacher) list.get(i)).getSalary();
            }
        }
        return count;
    }

    public static void displayAll(List<Person> list){
        for (Person p:list) {
            System.out.println(p);
        }
    }
}
