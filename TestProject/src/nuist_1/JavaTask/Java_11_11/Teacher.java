package nuist_1.JavaTask.Java_11_11;

public class Teacher {
    private int id;
    private String name;
    private int age;
    private String subject;
    private static int id_T = 10000;

    public Teacher() {
        this.id = ++id_T;
    }

    public Teacher(String name, int age,String subject) {
        this.name = name;
        this.age = age;
        this.subject=subject;
        this.id = ++id_T;
    }

    public int getId() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void show(){
        System.out.println("工号："+id+" 姓名："+name+" 年龄："+age+" 学科："+subject);
    }
}
