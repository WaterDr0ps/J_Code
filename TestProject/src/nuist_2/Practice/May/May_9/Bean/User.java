package nuist_2.Practice.May.May_9.Bean;

/**
 * @author Administrator
 */
public class User {
    private String loginName;
    private String password;
    private String realName;
    private char sex;
    private String phone;
    private double balance;

    public User() {
    }

    public User(String loginName, String password, String realName, char sex, String phone, double balance) {
        this.loginName = loginName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.phone = phone;
        this.balance = balance;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
