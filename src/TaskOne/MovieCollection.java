package TaskOne;
import java.util.*;
import java.util.stream.Collectors;
public class MovieCollection {
    protected List<Movie> movies;

    public MovieCollection(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public void printAll() {
        movies.forEach(System.out::println);
    }

    public List<Movie> searchByTitle(String keyword) {
        String lower = keyword.toLowerCase();
        return movies.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public List<Movie> sortByTitle() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Movie> sortByDirector() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getDirector, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Movie> sortByYear(boolean asc) {
        return movies.stream()
                .sorted(asc
                        ? Comparator.comparingInt(Movie::getYear)
                        : Comparator.comparingInt(Movie::getYear).reversed())
                .collect(Collectors.toList());
    }
}
