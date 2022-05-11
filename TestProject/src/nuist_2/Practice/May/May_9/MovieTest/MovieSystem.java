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

        Business b2 = new Business("京东环球影院", "123456", "刘强东", '男', "9999", 0, "京东环球影院", "万达广场");
        ALL_USERS.add(b2);
        List<Movie> movies2=new ArrayList<>();
        ALL_MOVIES.put(b2,movies2);
    }

    public static Scanner SYS_SC=new Scanner(System.in);

    /**
     * 创建一个当前用户
     */
    public static User USER;




    /**
     * 主方法
     */
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
           USER = getUserByLoginName(name);
            if(USER!=null){
                while (passwordErrorCount!=3) {
                    System.out.println("请输入密码：");
                    String password=SYS_SC.nextLine();
                    if(USER.getPassword().equals(password)){
                        if(USER instanceof Customer){
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

    /**
     * 商家界面
     */
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

    /**
     * 客户界面
     */
    private static void showCustomerPage() {
        while (true) {
            System.out.println("===================电影客户界面====================");
            System.out.println("1、展示全部影片");
            System.out.println("2、根据电影名称查询电影信息");
            System.out.println("3、评分功能");
            System.out.println("4、购票功能");
            System.out.println("5、退出系统");
            System.out.println("请输入操作命令：");
            String command=SYS_SC.nextLine();
            switch (command){
                default:
                    System.out.println("命令输入有误");
                    break;
                case "1":
                    showAllMovies();
                    break;
                case "2":
                    queryByMovieName();
                    break;
                case "3":
                    gradeMovie();
                    break;
                case "4":
                    buyTicket();
                    break;
                case "5":
                    return;
            }
        }

    }

    private static void modifyMovie() {
        showAllMovies();
        System.out.println("请输入要修改的名称");
        String name=SYS_SC.nextLine();
        for(Business key:ALL_MOVIES.keySet()){
            for(Movie value:ALL_MOVIES.get(key)){
                value.setName(name);
                System.out.println("修改成功！");
            }
        }
        showAllMovies();
    }

    private static void deleteMovie() {
        System.out.println("请输入要删除的电影名：");
        String name=SYS_SC.nextLine();
        Collection<List<Movie>> movies = ALL_MOVIES.values();
        for(List<Movie> m:movies){
            for(int i=m.size()-1;i>=0;i--){
                if(m.get(i).getName().equals(name)){
                    m.remove(i);
                    System.out.println("删除成功");
                    return;
                }else{
                    System.out.println("电影名不存在");
                }
            }
        }
    }

    private static void addMovie() {
        System.out.println("请输入新片名：");
        String name = SYS_SC.nextLine();
        System.out.println("请输入主演：");
        String actor=SYS_SC.nextLine();
        System.out.println("请输入时长：");
        int duration=SYS_SC.nextInt();
        System.out.println("请输入票价：");
        int price=SYS_SC.nextInt();
        System.out.println("请输入票数：");
        int surplus=SYS_SC.nextInt();
        SYS_SC.nextLine();
        System.out.println("请输入影片上映时间：");
        String showtime=SYS_SC.nextLine();
        Movie m=new Movie(name, actor,duration,price,surplus,showtime);
        List<Movie> list=new ArrayList<>();
        list.add(m);
        Business b=(Business)USER;
        ALL_MOVIES.put(b,list);
        System.out.println("您已经成功上架："+m.getName());
    }

    private static void showDetails() {
        System.out.println("===================电影商家详情====================");
        System.out.println("您当前个人信息如下：");
        Business b=(Business) USER;
        System.out.println(b.getRealName()+" 电话："+b.getPhone()+" 地址："+b.getAddress()+" 总收入："+b.getBalance());
        if(judgeMovieExist()){
            System.out.println("您的影院拍片信息如下：");
            System.out.println("\t\t\t影片名称\t\t主演\t时长\t票价\t余票\t放映时间");
            for(Business key:ALL_MOVIES.keySet()){
                for(Movie value:ALL_MOVIES.get(key)){
                    System.out.println("\t\t\t"+value.getName()+"\t\t\t"+value.getActor()+"\t\t"+value.getDuration()
                            +"\t\t"+value.getPrice()+"\t\t"+value.getSurplus()+"\t\t"+value.getShowtime());
                }
            }
        }else{
            System.out.println("您当前无任何排片信息~~");
        }
    }

    private static void buyTicket() {
        System.out.println("===================欢迎进入购票系统====================");
        showAllMovies();
        if(judgeMovieExist()){
            System.out.println("请输入要购买的电影:");
            String name=SYS_SC.nextLine();
            System.out.println("请输入要购买的数量：");
            String amount=SYS_SC.nextLine();
            while(!amount.matches("\\d+")){
                System.out.println("输入有误,请重新输入：");
                amount=SYS_SC.nextLine();
            }
            for(Business b:ALL_MOVIES.keySet()){
                for(Movie m:ALL_MOVIES.get(b)){
                    if (m.getSurplus()<=0||m.getSurplus()-Integer.parseInt(amount)<0) {
                        if(m.getName().equals(name)){
                            System.out.println("共"+amount+"张票，共："+Integer.parseInt(amount)*m.getPrice()+"元，请确认：(Y/N)");
                            String command=SYS_SC.nextLine();
                            if("Y".equals(command.toUpperCase())){
                                System.out.println("购买成功！");
                                m.setSurplus(m.getSurplus()-Integer.parseInt(amount));
                                showAllMovies();
                            }else{
                                System.out.println("购买失败");
                            }
                        }
                    } else {
                        System.out.println("票数不足");
                    }
                }
            }
        }else{
            System.out.println("抱歉，当前没有电影");
        }
    }

    private static void gradeMovie() {
        showAllMovies();
        System.out.println("请输入要评分的电影：");
        String name = SYS_SC.nextLine();
        for(Business b:ALL_MOVIES.keySet()){
            for(Movie m:ALL_MOVIES.get(b)){
                if(m.getName().equals(name)){
                    System.out.println("请输入您的评分(0-5)");
                    String grade=SYS_SC.nextLine();
                    while(!grade.matches("[0-4].[0-9]")){
                        System.out.println("输入有误，重新输入");
                        grade=SYS_SC.nextLine();
                    }
                    m.setGrade(Double.parseDouble(grade));
                    System.out.println("\t\t\t影片名称\t\t主演\t时长\t票价\t余票\t放映时间\t评分");
                    System.out.println("\t\t\t"+m.getName()+"\t\t\t"+m.getActor()+"\t\t"+m.getDuration()
                            +"\t\t"+m.getPrice()+"\t\t"+m.getSurplus()+"\t\t"+m.getShowtime()+"\t\t"+m.getGrade());
                }else{
                    System.out.println("电影不存在");
                }
            }
        }
    }

    private static void queryByMovieName() {
        System.out.println("请输入影片名称：");
        String name=SYS_SC.nextLine();
        for(Business b:ALL_MOVIES.keySet()){
            for(Movie m:ALL_MOVIES.get(b)){
                if(m.getName().equals(name)){
                    System.out.println(b.getStoreName()+" 电话："+b.getPhone()+" 地址："+b.getAddress());
                    System.out.println("\t\t\t影片名称\t\t主演\t时长\t票价\t余票\t放映时间");
                    System.out.println("\t\t\t"+m.getName()+"\t\t\t"+m.getActor()+"\t\t"+m.getDuration()
                            +"\t\t"+m.getPrice()+"\t\t"+m.getSurplus()+"\t\t"+m.getShowtime());
                }
            }
        }
    }

    private static void showAllMovies() {
        for(Business b:ALL_MOVIES.keySet()){
            System.out.println(b.getStoreName()+" 电话："+b.getPhone()+" 地址："+b.getAddress());
            System.out.println("\t\t\t影片名称\t\t主演\t时长\t票价\t余票\t放映时间");
            for(Movie m:ALL_MOVIES.get(b)){
                System.out.println("\t\t\t"+m.getName()+"\t\t\t"+m.getActor()+"\t\t"+m.getDuration()
                        +"\t\t"+m.getPrice()+"\t\t"+m.getSurplus()+"\t\t"+m.getShowtime());
            }
        }
    }

    private static User getUserByLoginName(String name) {
        for (User user : ALL_USERS) {
            if(user.getLoginName().equals(name)){
                return user;
            }
        }
        return null;
    }

    private static boolean judgeMovieExist(){
        for(Business key:ALL_MOVIES.keySet()){
            for(Movie value:ALL_MOVIES.get(key)){
                if(value!=null){
                    return true;
                }
            }
        }
        return false;
    }
}
