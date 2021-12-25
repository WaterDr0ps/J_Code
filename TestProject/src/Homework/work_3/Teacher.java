package Homework.work_3;

public class Teacher extends Person{
    private String teacherID;
    private double salary;

    public Teacher(){
    }

    public Teacher(String teacherID, double salary) {
        this.teacherID = teacherID;
        this.salary = salary;
    }

    public Teacher(String name, int age, String teacherID, double salary) {
        super(name, age);
        this.teacherID = teacherID;
        this.salary = salary;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
