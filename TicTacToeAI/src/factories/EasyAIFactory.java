package factories;

import players.EasyAI;
import players.Player;

public class EasyAIFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String label) {
        return new EasyAI(label);
    }

}
