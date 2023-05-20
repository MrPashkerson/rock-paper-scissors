package rps;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        if (!validateArgs(args)) {
            System.out.println("Invalid arguments. Please enter three or more unique moves. The number of moves must be odd. For example: rock scissors paper lizard Spock");
            return;
        }
        Game game = new Game(args);
        game.start();
    }

    private static boolean validateArgs(String[] args) {
        if (args.length % 2 == 0 || args.length < 3) return false;
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i].equalsIgnoreCase(args[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
