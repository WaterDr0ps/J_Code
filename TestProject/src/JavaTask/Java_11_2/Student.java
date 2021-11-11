package JavaTask.Java_11_2;

public class Student {
    private String name;
    private int age;
    private String ID;

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
        if (age <= 0) {
            System.out.println("年龄输入有误");
            this.age=-1;
        } else {
            this.age = age;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Student(){}
    public Student(String name,int age,String ID){
        setName(name);
        setAge(age);
        setID(ID);
    }

    void show(){
        System.out.println("姓名:"+getName()+(char)10+"年龄:"+getAge()+(char)10+"学号:"+getID());
    }
}
