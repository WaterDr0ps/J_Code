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
     private String showtime;

    public Movie() {
    }

    public Movie(String name, String actor, int duration, double price, int surplus,String showtime) {
        this.name = name;
        this.actor = actor;
        this.duration = duration;
        this.price = price;
        this.surplus = surplus;
        this.showtime=showtime;
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

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
}
