package org.example;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter start or exit");
            while (scanner.hasNext()) {
                str = scanner.next().toLowerCase();
                if (str.equals("start")) {
                    Game game = Game.getInstance();
                    game.start();
                    break;
                } else if (str.equals("exit")) {
                    scanner.close();
                    System.exit(0);
                } else {
                    System.out.println("You entered an incorrect command");

                }
            }

        }



    }

}
