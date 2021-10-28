package JavaTask.Java_10_28;

public class Cat {
    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("年龄有误");
        }
    }

    public void character(){
        System.out.println("猫的好奇心重，任何的东西都可以让猫感觉非常有新鲜感");
    }

    public void print() {
        System.out.println(name + ',' + age);
    }
}
