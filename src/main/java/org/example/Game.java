package org.example;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private final static int ATTEMPT = 6;
    private static Game instance;
    private static String[] hiddenWord;
    private String secretWord;
    private static int step;
    private static int mistakes;
    private int countGuessedLetters;

    private char[][] gallows;
    private String literal;

    private static List<String> listMistakes;

    private Game() {
        step = 0;
        mistakes = 0;
        countGuessedLetters = 0;
        literal = null;
        listMistakes = new ArrayList();
        secretWord = makeWord();
        if (secretWord != null) {
            hiddenWord = new String[secretWord.length()];
            for (int i = 0; i < secretWord.length(); i++) {
                hiddenWord[i] = ("-");
            }
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
            System.out.println("START GAME");
        }
        return instance;
    }

    public void start() {
        drawGallows();
        drawScreen();

        System.out.println("Enter literal");
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext() && mistakes < ATTEMPT) {



                literal = scanner.next();
                if (!secretWord.contains(literal)) {
                    listMistakes.add(literal);
                    mistakes++;

                } else {
                    Pattern pattern = Pattern.compile(literal);
                    Matcher matcher = pattern.matcher(secretWord);
                    while (matcher.find()) {
                        hiddenWord[matcher.end() - 1] = literal;
                        countGuessedLetters++;

                    }
                }
                step++;
                drawGallows();
                drawScreen();
                if (mistakes == ATTEMPT) {
                    System.out.println("You've lost. SecretWord: " + secretWord);
                    break;
                }
                if (countGuessedLetters == secretWord.length()) {
                    System.out.println("You have won !!!");
                    break;
                }
                System.out.println("Enter literal");
            }
        }

    }

    private void drawGallows() {
        gallows = new char[10][10];

        for (int i = 0; i < gallows.length; i++)
            for (int j = 0; j < gallows.length; j++) {
                gallows[i][j] = ' ';
            }

        gallows[2][4] = '|';
        gallows[1][5] = '-';
        gallows[1][6] = '-';
        gallows[1][7] = '-';
        gallows[1][8] = '|';
        gallows[2][8] = '|';
        gallows[3][8] = '|';
        gallows[4][8] = '|';
        gallows[5][8] = '|';
        gallows[6][8] = '|';
        gallows[7][8] = '|';
        gallows[8][8] = '|';
        gallows[9][0] = '-';
        gallows[9][1] = '-';
        gallows[9][2] = '-';
        gallows[9][3] = '−';
        gallows[9][4] = '-';
        gallows[9][5] = '-';
        gallows[9][6] = '-';
        gallows[9][7] = '-';
        gallows[9][8] = '-';
        gallows[9][9] = '-';

        switch (mistakes) {
            case 1 -> gallows[3][4] = 'O';
            case 2 -> {
                gallows[3][4] = 'O';
                gallows[5][4] = '|';
            }
            case 3 -> {
                gallows[3][4] = 'O';
                gallows[5][4] = '|';
                gallows[4][3] = '\\';
            }
            case 4 -> {
                gallows[3][4] = 'O';
                gallows[5][4] = '|';
                gallows[4][3] = '\\';
                gallows[4][5] = '/';
            }
            case 5 -> {
                gallows[3][4] = 'O';
                gallows[5][4] = '|';
                gallows[4][3] = '\\';
                gallows[4][5] = '/';
                gallows[6][3] = '/';
            }
            case 6 -> {
                gallows[3][4] = 'O';
                gallows[5][4] = '|';
                gallows[4][3] = '\\';
                gallows[4][5] = '/';
                gallows[6][3] = '/';
                gallows[6][5] = '\\';
            }


        }

    }


    private void drawScreen() {
        System.out.println("____________________________________________________________");
        System.out.print("WORD: ");

        for (int i = 0; i < hiddenWord.length; i++) {
            System.out.print(hiddenWord[i] + " ");
        }

        System.out.println();
        System.out.println("STEP: " + step);

        Arrays.stream(gallows).forEach(System.out::println); // отрисовываем висилицу

        System.out.print("Mistakes (" + mistakes + ")");

        for (String ch : listMistakes) {
            System.out.print(" " + ch + ",");

        }
        System.out.println();

        System.out.println("Literal: " + literal);

        System.out.println("____________________________________________________________");
    }

    private String makeWord() {
        DictionaryReader reader = new DictionaryReader();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("dictionary.txt").getFile());
        List<String> list = reader.readFile(file.getPath());
        int size = list.size();
        int index = randomNumber(size);

        return list.get(index);
    }

    private int randomNumber(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize - 1);
    }
}
