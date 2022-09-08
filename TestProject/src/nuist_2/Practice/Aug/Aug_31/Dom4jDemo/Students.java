package nuist_2.Practice.Aug.Aug_31.Dom4jDemo;

/**
 * @author Administrator
 */
public class Students {
    private String id;
    private String name;

    public Students() {
    }

    public Students(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
