package nuist_2.Practice.Apr.Apr_20;


/**
 * @author Eliot
 */
public class Keyboard implements Usb{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Keyboard(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println("键盘连接成功");
    }

    @Override
    public void unConnect() {
        System.out.println("键盘断开连接");
    }

    public void show(){
        System.out.println("我是一个"+name+"键盘");
    }
}
