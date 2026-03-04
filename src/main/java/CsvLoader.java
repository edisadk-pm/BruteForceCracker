import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static class Person {

        String vorname;
        String nachname;
        String hash;

        public Person(String v, String n, String h) {
            vorname = v;
            nachname = n;
            hash = h;
        }
    }

    public static List<Person> read(String path) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(path));
        List<Person> result = new ArrayList<>();

        for (String line : lines) {

            if (line.isBlank()) continue;

            String[] parts = line.split("[;,]");

            String vorname = parts[0].trim();
            String nachname = parts[1].trim();
            String hash = parts[2].trim();

            result.add(new Person(vorname, nachname, hash));
        }

        return result;
    }
}