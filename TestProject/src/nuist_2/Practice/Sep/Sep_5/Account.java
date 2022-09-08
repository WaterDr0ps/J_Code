package nuist_2.Practice.Sep.Sep_5;

/**
 * @author Administrator
 */
public class Account {
    private int id;
    private String city;
    private String edu;
    private int income;

    public Account() {
    }

    public Account(int id, String city, String edu, int income) {
        this.id = id;
        this.city = city;
        this.edu = edu;
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", edu='" + edu + '\'' +
                ", income=" + income +
                '}';
    }
}
