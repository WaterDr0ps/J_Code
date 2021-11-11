package JavaTask.Java_11_2;

public class Teacher {
    private String name;
    private int age;
    private String course;

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
        } else {
            this.age = age;
        }
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Teacher(){}
    public Teacher(String name, int age, String course){
        setName(name);
        setAge(age);
        setCourse(course);
    }

    void show(){
        System.out.println("姓名:"+getName()+(char)10+"年龄:"+getAge()+(char)10+"科目:"+getCourse());
    }
}
