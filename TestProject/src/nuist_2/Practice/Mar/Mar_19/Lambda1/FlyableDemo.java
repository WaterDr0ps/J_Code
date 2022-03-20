package nuist_2.Practice.Mar.Mar_19.Lambda1;

public class FlyableDemo {
    public static void main(String[] args) {
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("起飞");
            }
        });

        useFlyable((String s)->{
            System.out.println(s);
            System.out.println("起飞");
        });
    }

    private static void useFlyable(Flyable f){
        f.fly("晴空万里");
    }
}
