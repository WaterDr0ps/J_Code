package nuist_2.Practice.May.May_9.MovieTest;

import nuist_2.Practice.May.May_9.Bean.Business;
import nuist_2.Practice.May.May_9.Bean.Customer;
import nuist_2.Practice.May.May_9.Bean.Movie;
import nuist_2.Practice.May.May_9.Bean.User;

import java.util.*;

/**
 * @author Eliot
 */
public class MovieSystem {

    /**
     * 存放所有用户信息
     */
    public static List<User> ALL_USERS=new ArrayList<>();

    /**
     * 存放所有商家以及排片信息
     */
    public static Map<Business,List<Movie>> ALL_MOVIES=new HashMap<>();

    /**
     * 准备测试数据
     */
    static{
        Customer c1 = new Customer("张淘宝","123456", "张三", '男', "18019531877", 0);
        ALL_USERS.add(c1);

        Customer c2 = new Customer("李京东","123456", "李四", '男', "19855354809", 0);
        ALL_USERS.add(c2);


        Business b1 = new Business("淘宝环球影院", "123456", "马云", '男', "8888", 0, "淘宝环球影院", "苏宁广场");
        ALL_USERS.add(b1);
        List<Movie> movies1=new ArrayList<>();
        ALL_MOVIES.put(b1,movies1);

        Business b2 = new Business("淘宝环球影院", "123456", "马云", '男', "8888", 0, "淘宝环球影院", "苏宁广场");
        ALL_USERS.add(b2);
        List<Movie> movies2=new ArrayList<>();
        ALL_MOVIES.put(b2,movies2);
    }

    public static Scanner SYS_SC=new Scanner(System.in);

    public static void main(String[] args) {
        showLogin();
    }

    private static void showLogin() {
        System.out.println("===================欢迎登陆购票系统====================");
        while (true) {
            System.out.println("1、登陆");
            System.out.println("2、用户注册");
            System.out.println("3、商家注册");
            System.out.println("请输入操作命令：");
            String command=SYS_SC.nextLine();
            switch (command){
                default:
                    System.out.println("命令输入有误");
                case "1":
                    login();
                    break;
                case "2":
                case "3":
                    register();
                    break;
            }
        }
    }

    private static void register() {
    }

    private static void login() {
        while (true) {
            int passwordErrorCount=0;
            System.out.println("请输入登录名：");
            String name=SYS_SC.nextLine();
            User user = getUserByLoginName(name);
            if(user!=null){
                while (passwordErrorCount!=3) {
                    System.out.println("请输入密码：");
                    String password=SYS_SC.nextLine();
                    if(user.getPassword().equals(password)){
                        if(user instanceof Customer){
                            showCustomerPage();
                        }else{
                            showBusinessPage();
                        }
                        return;
                    }else{
                        System.out.println("密码错误");
                        passwordErrorCount++;
                    }
                    if(passwordErrorCount==3){
                        System.out.println("密码错误3次，重新输入登录名");
                    }
                }
            }else{
                System.out.println("登录名错误，请重新输入");
            }
        }
    }

    private static void showBusinessPage() {
        while (true) {
            System.out.println("===================电影商家界面====================");
            System.out.println("1、展示详情");
            System.out.println("2、上架电影");
            System.out.println("3、下架电影");
            System.out.println("4、修改电影");
            System.out.println("5、退出");
            System.out.println("请输入操作命令：");
            String command=SYS_SC.nextLine();
            switch (command){
                default:
                    System.out.println("命令输入有误");
                    break;
                case "1":
                    showDetails();
                    break;
                case "2":
                    addMovie();
                    break;
                case "3":
                    deleteMovie();
                    break;
                case "4":
                    modifyMovie();
                    break;
                case "5":
                    return;
            }
        }
    }

    private static void showCustomerPage() {

    }

    private static User getUserByLoginName(String name) {
        for (User user : ALL_USERS) {
            if(user.getLoginName().equals(name)){
                return user;
            }
        }
        return null;
    }
}
