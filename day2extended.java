import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class day2extended {

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

    public static int maxValue(ArrayList<Rgb> game) {
        int maxRed = 0;
        int maxBlue = 0;
        int maxGreen = 0;

        for (Rgb play : game) {

            // blue- 14
            // green- 13
            // red- 12
            if (play.r > maxRed) {
                maxRed = play.r;
            }
            if (play.g > maxGreen) {
                maxGreen = play.g;
            }
            if (play.b > maxBlue) {
                maxBlue = play.b;
            }
        }
        
        int powerSet = maxBlue*maxGreen*maxRed;

        return powerSet;
    }

    public static void main(String args[]) throws IOException {

        Path path = Paths.get("day2input.txt");
        Scanner scanner = new Scanner(path);

        int gameId = 1;
        int result = 0;
    
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Rgb> game = parseGame(line);
            int maxValue = maxValue(game);

            result = result + maxValue;
        }

        System.out.println(result);
    }
}
