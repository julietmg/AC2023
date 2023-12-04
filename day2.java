import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {

    static class Rgb {
        int r;
        int g;
        int b;

        public Rgb(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public static ArrayList<Rgb> parseGame(String gameDescription) {
        String games = gameDescription.split(":")[1];
        String plays[] = games.split(";");
        ArrayList<Rgb> result = new ArrayList<Rgb>();
        for (String play : plays) {
            // play is something like: "9 red, 2 green, 13 blue"
            String[] factors = play.split(",");

            int r = 0;
            int g = 0;
            int b = 0;

            for (String factor : factors) {
                factor = factor.strip();
                // now, factor is something like: "9 red"
                String[] parts = factor.split(" ");
                String count = parts[0];
                String color = parts[1];
                if (color.equals("red")) {
                    r = Integer.parseInt(count);
                } else if (color.equals("green")) {
                    g = Integer.parseInt(count);
                } else if (color.equals("blue")) {
                    b = Integer.parseInt(count);
                }
            }

            result.add(new Rgb(r, g, b));
        }
        return result;
    }

    public static boolean isLegal(ArrayList<Rgb> game) {

        for (Rgb play : game) {

            // blue- 14
            // green- 13
            // red- 12
            if (play.r > 12) {
                return false;
            }
            if (play.g > 13) {
                return false;
            }
            if (play.b > 14) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {

        Path path = Paths.get("day2input.txt");
        Scanner scanner = new Scanner(path);

        int gameId = 1;
        int result = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Rgb> game = parseGame(line);
            boolean isLegal = isLegal(game);

            // System.out.println("GAME WITH ID: " + gameId);
            // System.out.println(line);
            // System.out.println(isLegal);

            if(isLegal) {
                result = result + gameId;
            }

            gameId = gameId + 1;
        }

        System.out.println(result);
    }
}
