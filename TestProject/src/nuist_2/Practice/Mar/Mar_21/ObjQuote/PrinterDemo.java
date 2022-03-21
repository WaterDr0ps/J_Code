package nuist_2.Practice.Mar.Mar_21.ObjQuote;

public class PrinterDemo {
    public static void main(String[] args) {
        usePrinter(s-> System.out.println(s.toUpperCase()));

        PrintString ps=new PrintString();
        usePrinter(ps::printUpper);
    }

    private static void usePrinter(Printer s){
        s.printUpperCase("hello");
    }
}
