package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Enter start or exit");
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();

            do {
                if (str.equals("start")) {
                    Game game = Game.getInstance();
                    game.start();
                    break;
                } else if (!str.equals("exit")) {
                    System.out.println("You entered an incorrect command");
                    break;
                }
            } while (!str.equals("exit"));
        }
    }
}
