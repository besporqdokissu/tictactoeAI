package otherServices.game;

public class Game implements IGame {

    public boolean isFinished(String[][] map) {
        if (isWin(map, "X"))
        {
            return true;
        }
        if (isWin(map, "O"))
        {
            return true;
        }
        return isDraw(map);
    }

    public boolean isWin(String[][] map, String currentPlayer) {
        return (
                map[0][0].equals(currentPlayer) && map[0][1].equals(currentPlayer) && map[0][2].equals(currentPlayer) ||
                map[1][0].equals(currentPlayer) && map[1][1].equals(currentPlayer) && map[1][2].equals(currentPlayer) ||
                map[2][0].equals(currentPlayer) && map[2][1].equals(currentPlayer) && map[2][2].equals(currentPlayer) ||
                map[0][0].equals(currentPlayer) && map[1][0].equals(currentPlayer) && map[2][0].equals(currentPlayer) ||
                map[0][1].equals(currentPlayer) && map[1][1].equals(currentPlayer) && map[2][1].equals(currentPlayer) ||
                map[0][2].equals(currentPlayer) && map[1][2].equals(currentPlayer) && map[2][2].equals(currentPlayer) ||
                map[0][0].equals(currentPlayer) && map[1][1].equals(currentPlayer) && map[2][2].equals(currentPlayer) ||
                map[0][2].equals(currentPlayer) && map[1][1].equals(currentPlayer) && map[2][0].equals(currentPlayer)
               );
    }

    public boolean isDraw(String[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j]);
            }
        }
        return !sb.toString().contains(" ");
    }
}
