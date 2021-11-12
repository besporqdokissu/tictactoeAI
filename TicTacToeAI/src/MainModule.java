
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import factories.*;
import otherServices.game.Game;
import otherServices.game.IGame;
import otherServices.validotor.IValidator;
import otherServices.validotor.InputValidator;

public class MainModule extends AbstractModule{

    protected void configure(){


        bind(PlayerFactory.class).annotatedWith(Names.named("user")).to(UserFactory.class);

        bind(PlayerFactory.class).annotatedWith(Names.named("easy")).to(EasyAIFactory.class);

        bind(PlayerFactory.class).annotatedWith(Names.named("medium")).to(MediumAIFactory.class);

        bind(PlayerFactory.class).annotatedWith(Names.named("smart")).to(SmartAIFactory.class);

        bind(IValidator.class).to(InputValidator.class);

        bind(IGame.class).to(Game.class);

    }
}