package nuist_2.Practice.Apr.Apr_5;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    private void function() {
        System.out.println("function");
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2(String s) {
        System.out.println("method2:" + s);
    }

    public String method3(String s, int i) {
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
