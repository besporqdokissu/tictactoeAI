package players;

import otherServices.game.IGame;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SmartAI implements Player {
    final private String label;
    final private String enemyLabel;
    final private boolean aiTurn = true;
    final private boolean userTurn = false;
    private Random random;
    private IGame game;

    public SmartAI(String label, IGame game) {
        this.label = label;
        this.enemyLabel = label.equals("X") ? "O" : "X";
        this.game = game;
        random = new Random();
    }

    public String getLabel() {
        return label;
    }

    public int[] getMove(String[][] map) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(700);

        //is that game`s start?
        boolean empty = true;
        for (String[] strings : map) {
            if (Arrays.asList(strings).contains(enemyLabel)) {
                empty = false;
                break;
            }
        }
        if (empty) {
            while (true) {
                int first = random.nextInt(map.length);
                int second = random.nextInt(map[0].length);
                if (map[first][second].equals(" ")) {
                    return new int[]{first, second};
                }
            }
        }


        int first = 0;
        int second = 0;
        int bestScore = -2147483648;
        String[][] board = map.clone();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals(" ")) {
                    board[i][j] = label;
                    int score = minimax(board, userTurn);
                    board[i][j] = " ";
                    if (score > bestScore) {
                        bestScore = score;
                        first = i;
                        second = j;
                    }
                }
            }
        }
        return new int[]{first, second};
    }

    private int minimax(String[][] board,  boolean isAiTurn) {

        if (game.isWin(board, label)) return 1;
        if (game.isWin(board, enemyLabel)) return -1;
        if (game.isDraw(board)) return 0;

        int bestScore;
        if (isAiTurn) {
            bestScore = -2147483647;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = label;
                        int score = minimax(board, userTurn);
                        board[i][j] = " ";
                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
        } else {
            bestScore = 2147483647;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = enemyLabel;
                        int score = minimax(board, aiTurn);
                        board[i][j] = " ";
                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
        }
        return bestScore;
    }
}