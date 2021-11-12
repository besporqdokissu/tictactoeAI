package otherServices.game;

public interface IGame {
    boolean isDraw(String[][] map);

    boolean isWin(String[][] map, String currentPlayer);
}
