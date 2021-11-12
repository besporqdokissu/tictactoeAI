package players;

public interface Player {

    String getLabel();

    int[] getMove(String[][] map) throws InterruptedException;

}


