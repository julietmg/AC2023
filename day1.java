import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

public class day1 {




    public static void main (String args[]) throws IOException {

    Path path = Paths.get("day1input.txt");
    Scanner scanner = new Scanner(path); 

    int sum = 0;
    while(scanner.hasNextLine()) {
        String line = scanner.nextLine();  
        // System.out.println(line); 

        boolean wasFound = false;
        char firstNum='0';
        char secondNum='0';

        for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if(c >= 48 && c < 58) {
                if(wasFound == false) {
                    firstNum = c;
                    wasFound = true;
                }
                secondNum = c;
            }

            // System.out.println("After reading the character " + c + " firstNum is: " + firstNum);
            // System.out.println("After reading the character " + c + " secondNum is: " + secondNum);
        }

        String firstNumber = Character.toString(firstNum);
        String secondNumber = Character.toString(secondNum);
        String finalNumber = firstNumber + secondNumber;
        int number = Integer.parseInt(finalNumber);

        System.out.println(line);
        System.out.println(number);

        sum = sum + number;
        

    
    }
    System.out.println(sum);

    scanner.close();





    }
}



