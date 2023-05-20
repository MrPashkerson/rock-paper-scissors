package rps;

public class TableGenerator {
    private final String[] moves;

    public TableGenerator(String[] moves) {
        this.moves = moves;
    }

    public String generateTable() {
        StringBuilder table = new StringBuilder("               ");
        for (String move : moves) {
            table.append(String.format("%-15s", move));
        }
        table.append("\n");

        for (int i = 0; i < moves.length; i++) {
            table.append(String.format("%-15s", moves[i]));
            for (int j = 0; j < moves.length; j++) {
                if (i == j) {
                    table.append(String.format("%-15s", "Draw"));
                    continue;
                }

                int diff = (moves.length + j - i) % moves.length;
                if (diff > moves.length / 2) {
                    table.append(String.format("%-15s", "Win"));
                } else {
                    table.append(String.format("%-15s", "Lose"));
                }
            }
            table.append("\n");
        }
        return table.toString();
    }
}
