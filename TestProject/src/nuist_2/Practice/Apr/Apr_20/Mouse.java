package nuist_2.Practice.Apr.Apr_20;


/**
 * @author Eliot
 */
public class Mouse implements Usb {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println("鼠标连接成功");
    }

    @Override
    public void unConnect() {
        System.out.println("鼠标断开连接");
    }

    public void show(){
        System.out.println("我是一个"+name+"鼠标");
    }
}
