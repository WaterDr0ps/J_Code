package nuist_2.Practice.Aug.Aug_30;

/**
 * @author Administrator
 */
public class ReflectDemo {
    private String name;
    private char sex;
    private int age;

    public ReflectDemo() {
    }

    public ReflectDemo(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void method1(String s){
        System.out.println("一个参数");
    }
    public void method2(){
        System.out.println("无参");
    }
    public void method2(String s,int a){
        System.out.println("两个参数");
    }
}

