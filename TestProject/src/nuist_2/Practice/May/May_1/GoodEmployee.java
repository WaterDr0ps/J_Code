package nuist_2.Practice.May.May_1;

/**
 * @author Eliot
 */
public class GoodEmployee {
    private String name;

    public GoodEmployee() {
    }

    public GoodEmployee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "优秀员工是:"+name;
    }
}
