package nuist_2.Practice.May.May_9.Bean;

/**
 * @author Administrator
 */
public class Movie {
     private String name;
     private String actor;
     private double grade;
     private int duration;
     private double price;
     private int surplus;

    public Movie() {
    }

    public Movie(String name, String actor, double grade, int duration, double price, int surplus) {
        this.name = name;
        this.actor = actor;
        this.grade = grade;
        this.duration = duration;
        this.price = price;
        this.surplus = surplus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }
}
