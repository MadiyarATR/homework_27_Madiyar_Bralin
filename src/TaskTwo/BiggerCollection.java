package TaskTwo;
import TaskOne.*;
import java.util.*;
import java.util.stream.Collectors;

public class BiggerCollection extends MovieCollection {
    public BiggerCollection(List<Movie> movies) {
        super(movies);
    }
    public List<Movie> searchByActor(String actor) {
        String lower = actor.toLowerCase();
        return getMovies().stream()
                .filter(m -> m.getActors().stream()
                        .anyMatch(a -> a.toLowerCase().contains(lower)))
                .collect(Collectors.toList());
    }

    public List<Movie> searchByDirector(String director) {
        String lower = director.toLowerCase();
        return getMovies().stream()
                .filter(m -> m.getDirector().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public List<Movie> searchByYear(int year) {
        return getMovies().stream()
                .filter(m -> m.getYear() == year)
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> actorsWithRoles() {
        Map<String, List<String>> map = new HashMap<>();
        for (Movie m : getMovies()) {
            for (String actor : m.getActors()) {
                map.computeIfAbsent(actor, k -> new ArrayList<>()).add(m.getTitle());
            }
        }
        return map;
    }
}
