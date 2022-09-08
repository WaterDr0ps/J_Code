package nuist_2.Practice.Aug.Aug_31;

/**
 * @author Administrator
 */
public class Cat implements CatSkills{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println("猫咪会跳！");
    }

    @Override
    public void climb() {
        System.out.println("猫咪会爬！");
    }
}
