package JavaTask.Java_10_28;

public class Test {
    public static void main(String[] args) {
        Cat Tom=new Cat("Tom",81);
        Tom.print();
        System.out.println(Tom.getName()+"------"+ Tom.getAge());
        Tom.character();
        Mouse Jerry=new Mouse("Jerry",81);
        Jerry.print();
        System.out.println(Jerry.getName()+"------"+ Jerry.getAge());
        Jerry.character();
    }
}
