package nuist_1.JavaTask.Java_11_11;

public class Student {
    private long id;
    private String name;
    private int age;
    public static long id_S = 201936170000L;

    public Student() {
        this.id = ++id_S;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++id_S;
    }

    public long getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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

    public void show(){
        System.out.println("学号："+id+" 姓名："+name+" 年龄："+age);
    }
}
