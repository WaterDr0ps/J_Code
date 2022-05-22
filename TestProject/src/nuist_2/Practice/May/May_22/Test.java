package nuist_2.Practice.May.May_22;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * @author Eliot
 */
public class Test {
    public interface CLibrary extends Library{
        CLibrary INSTANCE=(CLibrary) Native.load((Platform.isWindows()?"msvcrt":"c"),CLibrary.class);
        void printf(String format,Object...args);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("val:100");
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Argument %d:%s/n",i,args[i]);
        }
    }
}
