package nuist_2.Practice.May.May_9.Bean;

import java.util.Objects;

/**
 * @author Administrator
 */
public class Business extends User{
    private String storeName;
    private String address;

    public Business() {
    }

    public Business(String loginName, String password, String realName, char sex, String phone, double balance, String storeName, String address) {
        super(loginName, password, realName, sex, phone, balance);
        this.storeName = storeName;
        this.address = address;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Business business = (Business) o;
        return Objects.equals(storeName, business.storeName) && Objects.equals(address, business.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName, address);
    }
}
