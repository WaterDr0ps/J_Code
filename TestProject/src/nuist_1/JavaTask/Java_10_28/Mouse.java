package nuist_1.JavaTask.Java_10_28;

public class Mouse {
    private String name;
    private int age;

    public Mouse() {
    }

    public Mouse(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void character() {
        System.out.println("老鼠十分聪明,记忆力很强");
    }

    public void print() {
        System.out.println(name + ',' + age);
    }
}
