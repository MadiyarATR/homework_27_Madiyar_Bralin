package TaskTwo;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import TaskOne.*;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            Type movieListType = new TypeToken<List<Movie>>(){}.getType();

            List<Movie> movies = gson.fromJson(new FileReader("source/movies.json"), movieListType);
            BiggerCollection collection = new BiggerCollection(movies);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n=== МЕНЮ ===");
                System.out.println("1. Показать все фильмы");
                System.out.println("2. Поиск по названию");
                System.out.println("3. Поиск по актеру");
                System.out.println("4. Поиск по режиссеру");
                System.out.println("5. Поиск по году");
                System.out.println("6. Сортировка по названию");
                System.out.println("7. Сортировка по режиссеру");
                System.out.println("8. Сортировка по году");
                System.out.println("9. Показать актеров с фильмами");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        collection.printAll();
                        break;
                    case 2:
                        System.out.print("Введите название: ");
                        String title = scanner.nextLine();
                        collection.searchByTitle(title).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Введите имя актера: ");
                        String actor = scanner.nextLine();
                        collection.searchByActor(actor).forEach(System.out::println);
                        break;
                    case 4:
                        System.out.print("Введите имя режиссера: ");
                        String director = scanner.nextLine();
                        collection.searchByDirector(director).forEach(System.out::println);
                        break;
                    case 5:
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        collection.searchByYear(year).forEach(System.out::println);
                        break;
                    case 6:
                        collection.sortByTitle().forEach(System.out::println);
                        break;
                    case 7:
                        collection.sortByDirector().forEach(System.out::println);
                        break;
                    case 8:
                        collection.sortByYear(true).forEach(System.out::println);
                        break;
                    case 9:
                        Map<String, List<String>> actorsMap = collection.actorsWithRoles();
                        actorsMap.forEach((a, filmsList) ->
                                System.out.println(a + " → " + filmsList));
                        break;
                    case 0:
                        System.out.println("Выход из программы...");
                        break;
                    default:
                        System.out.println("Некорректный ввод.");
                }
            } while (choice != 0);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
