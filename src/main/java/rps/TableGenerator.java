package rps;

import com.github.freva.asciitable.AsciiTable;

public class TableGenerator {
    private final String[] moves;

    public TableGenerator(String[] moves) {
        this.moves = moves;
    }

    public String generateTable() {
        String[] headers = new String[moves.length + 1];
        headers[0] = "Moves";
        System.arraycopy(moves, 0, headers, 1, moves.length);

        String[][] data = new String[moves.length][moves.length + 1];
        for (int i = 0; i < moves.length; i++) {
            data[i][0] = moves[i];

            for (int j = 0; j < moves.length; j++) {
                if (i == j) {
                    data[i][j + 1] = "Draw";
                } else {
                    int diff = (moves.length + j - i) % moves.length;
                    if (diff > moves.length / 2) {
                        data[i][j + 1] = "Win";
                    } else {
                        data[i][j + 1] = "Lose";
                    }
                }
            }
        }

        return AsciiTable.getTable(headers,data);
    }
}
