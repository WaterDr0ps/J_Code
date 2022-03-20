package nuist_2.Practice.Mar.Mar_19;

public class text {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程启动了");
            }
        }).start();
    }
}
