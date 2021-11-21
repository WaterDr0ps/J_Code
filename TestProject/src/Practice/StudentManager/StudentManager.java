package Practice.StudentManager;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int index;
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            System.out.println("\n-------欢迎来到学生管理系统-------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.print("请输入你的选择:");
            if ((index = sc.nextInt()) == 5) {
                System.out.println("感谢你的使用！");
                break;
            }
            ;
            switch (index) {
                case 1:
                    addStudent(array);
                    break;
                case 2:
                    deleteStudent(array);
                    break;
                case 3:
                    updateStudent(array);
                    break;
                case 4:
                    showAllStudent(array);
                    break;
                default:
                    System.out.println("输入错误,请重新输入！");
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.print("请输入学号:");
        s.setId(sc.nextLine());
        System.out.print("请输入姓名:");
        s.setName(sc.nextLine());
        System.out.print("请输入年龄:");
        s.setAge(sc.nextLine());
        System.out.print("请输入地址:");
        s.setAddress(sc.nextLine());
        array.add(s);
        System.out.println("学生添加成功！");
    }

    public static void showAllStudent(ArrayList<Student> array) {
        if(array.size()==0){
            System.out.println("请先添加数据！");
        }else{
            System.out.println("学号\t\t\t姓名\t\t年龄\t\t地址");
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getId() + "\t\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
            }
        }
    }

    public static void deleteStudent(ArrayList<Student> array) {
        System.out.print("请输入要删除学生的学号:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for(int i=0;i< array.size();i++){
            Student s= array.get(i);
            if(s.getId().equals(id)){
                array.remove(i);
                System.out.println("删除成功！");
                break;
            }else{
                System.out.println("学号不存在！");
            }
        }
    }

    public static void updateStudent(ArrayList<Student> array) {
        System.out.print("请输入要修改学生的学号：");
        Scanner sc=new Scanner(System.in);
        String id=sc.nextLine();
        Student s=new Student();
        System.out.print("请输入新的学号：");
        s.setId(sc.nextLine());
        System.out.print("请输入新的姓名：");
        s.setName(sc.nextLine());
        System.out.print("请输入新的年龄：");
        s.setAge(sc.nextLine());
        System.out.print("请输入新的地址：");
        s.setAddress(sc.nextLine());
        for(int i=0;i<array.size();i++){
            Student stu=array.get(i);
            if(stu.getId().equals(id)){
                array.set(i,s);
                System.out.println("修改成功！");
                break;
            }else{
                System.out.println("学号错误！");
            }
        }
    }
}
