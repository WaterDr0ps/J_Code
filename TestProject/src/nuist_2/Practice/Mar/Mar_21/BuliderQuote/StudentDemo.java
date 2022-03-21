package nuist_2.Practice.Mar.Mar_21.BuliderQuote;

public class StudentDemo {
    public static void main(String[] args) {
        useStudentBuilder(((name, age) -> new Student(name,age)));

        useStudentBuilder(Student::new);
    }

    private static void useStudentBuilder(StudentBuilder sb){
        Student s = sb.build("张三", 15);
        System.out.println(s.getName()+","+s.getAge());
    }
}
