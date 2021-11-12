package factories;
import players.Player;

public interface PlayerFactory {
    Player createPlayer(String label);
}
