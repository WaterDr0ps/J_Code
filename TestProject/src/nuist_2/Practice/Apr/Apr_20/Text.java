package nuist_2.Practice.Apr.Apr_20;


/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        Computer c=new Computer();
        Usb u=new Mouse("牧马人");
        c.start();
        c.installUsb(u) ;

    }
}
