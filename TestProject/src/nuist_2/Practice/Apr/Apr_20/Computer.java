package nuist_2.Practice.Apr.Apr_20;


/**
 * @author Eliot
 */
public class Computer {
    public void start(){
        System.out.println("电脑开机");
    }
    public void installUsb(Usb usb){
        if(usb instanceof Keyboard){
            usb.connect();
            Keyboard k=(Keyboard) usb;
            k.show();
            usb.unConnect();
        }else if(usb instanceof Mouse){
            usb.connect();
            Mouse m=(Mouse) usb;
            m.show();
            usb.unConnect();
        }
    }
}
