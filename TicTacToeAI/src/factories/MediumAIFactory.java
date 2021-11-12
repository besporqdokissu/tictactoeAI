package factories;

import players.MediumAI;
import players.Player;

public class MediumAIFactory implements PlayerFactory {
    @Override
    public Player createPlayer(String label){
        return new MediumAI(label);
    }
}
