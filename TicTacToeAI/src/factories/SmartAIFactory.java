package factories;

import otherServices.game.IGame;
import players.Player;
import players.SmartAI;
import javax.inject.Inject;

public class SmartAIFactory implements PlayerFactory {
    @Inject IGame game;
    @Override
    public Player createPlayer(String label){
        return new SmartAI(label, game);
    }
}
