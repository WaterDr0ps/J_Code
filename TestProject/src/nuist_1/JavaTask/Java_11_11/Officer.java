package nuist_1.JavaTask.Java_11_11;

import java.text.DecimalFormat;

public class Officer {
    private String  id;
    private String name;
    private int age;
    private String occupation;
    private static int id_O = 000;

    public Officer() {
        this.id = new DecimalFormat("000").format(++id_O);
    }

    public Officer(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.id = new DecimalFormat("000").format(++id_O);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void show(){
        System.out.println("工号："+id+" 姓名："+name+" 年龄："+age+" 职业："+ occupation);
    }
}
