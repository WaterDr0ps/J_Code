package nuist_2.Practice.Aug.Aug_31;

/**
 * @author Administrator
 */
public class CatTest {
    public static void main(String[] args) {
        Cat c=new Cat("小喵");
        CatSkills proxy = CatAgentProxy.getProxy(c);
        proxy.jump();
        proxy.climb();
    }
}
