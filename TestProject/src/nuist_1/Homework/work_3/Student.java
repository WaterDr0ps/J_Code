package nuist_1.Homework.work_3;

public class Student extends Person implements Learnable {
    private String studentID;
    private String major;

    public Student() {
    }

    public Student(String studentID, String major) {
        this.studentID = studentID;
        this.major = major;
    }

    public Student(String name, int age, String studentID, String major) {
        super(name, age);
        this.studentID = studentID;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public void study() {
        System.out.println("已经在学了！");
    }

    @Override
    public void exercise() {
        System.out.println("做一百套卷子！");
    }

    @Override
    public String toString(){
        return super.toString()+",学号："+studentID+",专业："+major;
    }
}
