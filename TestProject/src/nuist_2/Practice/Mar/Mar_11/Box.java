package nuist_2.Practice.Mar.Mar_11;

public class Box {
    private int milk;

    public void put(int milk){
        this.milk=milk;
        System.out.println("送奶工送第"+this.milk+"瓶奶");
    }
    public void get(){
        System.out.println("用户拿到第"+this.milk+"瓶奶");
    }
}
