package nuist_2.Practice.May.May_9.Bean;

/**
 * @author Administrator
 */
public class Customer extends User{


    public Customer() {
    }

    public Customer(String loginName, String password, String realName, char sex, String phone, double balance) {
        super(loginName, password, realName, sex, phone, balance);
    }
}
