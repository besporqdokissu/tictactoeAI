package players;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MediumAI implements Player {
    private final String label;
    private final String enemyLabel;
    Random random = new Random();

    public MediumAI(String label) {
        this.label = label;
        this.enemyLabel = label.equals("X") ? "O" : "X";
    }

    public String getLabel() {
        return label;
    }

    public int[] getMove(String[][] map) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(700);

        String[] players = {label, enemyLabel};
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < 3; i++) {
                if (
                        map[i][2].equals(" ") &&
                                map[i][0].equals(players[p]) &&
                                map[i][1].equals(players[p])
                ) {
                    return new int[]{1, 2};
                }
                if (
                        map[i][0].equals(" ") &&
                                map[i][1].equals(map[i][2]) &&
                                map[i][2].equals(players[p])) {
                    return new int[]{i, 0};
                }
                if (
                        map[i][1].equals(" ") &&
                                map[i][0].equals(map[i][2]) &&
                                map[i][2].equals(players[p])) {
                    return new int[]{i, 1};
                }
            }
            for (int j = 0; j < 3; j++) {
                if (
                        map[2][j].equals(" ") &&
                                map[0][j].equals(map[1][j]) &&
                                map[1][j].equals(players[p])) {
                    return new int[]{2, j};
                }
                if (
                        map[0][j].equals(" ") &&
                                map[1][j].equals(map[2][j]) &&
                                map[2][j].equals(players[p])) {
                    return new int[]{0, j};
                }
                if (
                        map[1][j].equals(" ") &&
                                map[0][j].equals(map[2][j]) &&
                                map[2][j].equals(players[p])) {
                    return new int[]{1, j};
                }
            }
            if (
                    map[0][2].equals(" ") &&
                            map[2][0].equals(map[1][1]) &&
                            map[1][1].equals(players[p])) {
                return new int[]{0, 2};
            }
            if (
                    map[2][0].equals(" ") &&
                            map[1][1].equals(map[0][2]) &&
                            map[0][2].equals(players[p])) {
                return new int[]{2, 0};
            }
            if (
                    map[1][1].equals(" ") &&
                            map[0][2].equals(map[2][0]) &&
                            map[2][0].equals(players[p])) {
                return new int[]{1, 1};
            }
            if
            (
                    map[2][2].equals(" ") &&
                            map[0][0].equals(players[p]) &&
                            map[1][1].equals(players[p])
            ) {
                return new int[]{2, 2};
            }
            if
            (
                    map[0][0].equals(" ") &&
                            map[2][2].equals(map[1][1]) &&
                            map[1][1].equals(players[p])
            ) {
                return new int[]{0, 0};
            }
            if (
                    map[1][1].equals(" ") &&
                            map[0][0].equals(map[2][2]) &&
                            map[2][2].equals(players[p])) {
                return new int[]{1, 1};
            }
        }

        while (true) {
            int first = random.nextInt(3);
            int second = random.nextInt(3);
            if (map[first][second].equals(" ")) {
                return new int[]{first, second};
            }
        }
    }
}

 /*
        1 If it already has two in a row and can win with one further move, it does so.
        2 If its opponent can win with one move, it plays the move necessary to block this.
        3 Otherwise, it makes a random move.
         */
