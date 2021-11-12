package factories;

import otherServices.validotor.IValidator;
import otherServices.validotor.InputValidator;
import players.Player;
import players.User;
import javax.inject.Inject;

public class UserFactory implements PlayerFactory {
    @Inject IValidator validator;
    @Override
    public Player createPlayer(String label){
        return new User(validator, label);
    }
}
