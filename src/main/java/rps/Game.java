package rps;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Game {
    private final String[] moves;
    private final RuleChecker ruleChecker;
    private final KeyGenerator keyGenerator;
    private final String secretKey;

    public Game(String[] moves) throws NoSuchAlgorithmException {
        this.moves = moves;
        this.ruleChecker = new RuleChecker(moves);
        this.keyGenerator = new KeyGenerator();
        this.secretKey = keyGenerator.generateKey();
    }

    public void start() throws NoSuchAlgorithmException, InvalidKeyException {
        Scanner scanner = new Scanner(System.in);
        int computerMove = (int) (Math.random() * moves.length);
        String hmac = keyGenerator.generateHmac(secretKey, moves[computerMove]);

        System.out.println("HMAC: " + hmac);

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("You exited the game.");
                break;
            }
            if (input.equals("?")) {
                printHelp();
                continue;
            }

            int userMove;
            try {
                userMove = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid move. Please input a number between 0 and " + moves.length + " or ? for help.");
                continue;
            }

            if (userMove < 0 || userMove >= moves.length) {
                System.out.println("Invalid move. Please input a number between 0 and " + moves.length + " or ? for help.");
                continue;
            }

            System.out.println("Your move: " + moves[userMove]);
            System.out.println("Computer move: " + moves[computerMove]);
            printResult(ruleChecker.check(userMove, computerMove));
            System.out.println("HMAC key: " + secretKey);
            break;
        }
    }

    private void printMenu() {
        System.out.println("Available moves:");
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + " - " + moves[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
        System.out.print("Enter your move: ");
    }

    private void printHelp() {
        System.out.println("Game rules:");
        TableGenerator tableGenerator = new TableGenerator(moves);
        System.out.println(tableGenerator.generateTable());
    }

    private void printResult(RuleChecker.Result result) {
        switch (result) {
            case WIN -> System.out.println("You win!");
            case LOSE -> System.out.println("You lose!");
            case DRAW -> System.out.println("Draw!");
        }
    }
}
