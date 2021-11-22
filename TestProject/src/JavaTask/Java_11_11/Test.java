package JavaTask.Java_11_11;

public class Test {
    public static void main(String[] args) {
        Student s1=new Student("刘某",20);
        s1.show();
        Student s2=new Student("卢某",21);
        s2.show();

        Teacher t1=new Teacher("王哥",30,"Java");
        t1.show();
        Teacher t2=new Teacher();
        t2.setName("王总");
        t2.setAge(31);
        t2.setSubject("Jaaaaaaaava");
        System.out.println("工号："+t2.getId()+" 姓名："+t2.getName()+" 年龄："+t2.getAge()+" 科目："+t2.getSubject());

        Officer o1=new Officer("李成功",20,"警察");
        o1.show();
        Officer o2=new Officer("王厉害",22,"警长");
        o2.show();
    }
}
