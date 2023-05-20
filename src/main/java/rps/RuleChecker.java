package rps;

public class RuleChecker {
    private final String[] moves;

    public RuleChecker(String[] moves) {
        this.moves = moves;
    }

    public Result check(int userMove, int computerMove) {
        if (userMove == computerMove) return Result.DRAW;
        int diff = (moves.length + userMove - computerMove) % moves.length;
        if (diff > moves.length / 2) {
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
    }

    public enum Result {
        WIN, LOSE, DRAW
    }
}
