package TaskOne;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            Type movieListType = new TypeToken<List<Movie>>(){}.getType();
            List<Movie> movies = gson.fromJson(new FileReader("source/movies.json"), movieListType);

            MovieCollection collection = new MovieCollection(movies);

            System.out.println("Все фильмы:");
            collection.printAll();

            System.out.println("\nПоиск по названию (Matrix):");
            collection.searchByTitle("Matrix").forEach(System.out::println);

            System.out.println("\nСортировка по названию:");
            collection.sortByTitle().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
