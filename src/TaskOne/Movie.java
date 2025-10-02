package TaskOne;
import java.util.List;
public class Movie {
    private String title;
    private int year;
    private String director;
    private List<String> actors;

    public Movie(String title, int year, String director, List<String> actors) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getDirector() { return director; }
    public List<String> getActors() { return actors; }

    @Override
    public String toString() {
        return year + " - " + title + " (Director: " + director + ")";
    }
}
