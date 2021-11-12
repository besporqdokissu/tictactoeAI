import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import factories.PlayerFactory;
import otherModel.Map;
import otherServices.game.Game;
import players.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new MainModule());
        Map map = new Map();
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String scanned = scanner.nextLine();
        String[] input = scanned.split(" ");

        Binding<PlayerFactory> bindingP1 = injector
                .getExistingBinding(Key.get
                (PlayerFactory.class,
                 Names.named(input[0])));

        Binding<PlayerFactory> bindingP2 = injector
                .getExistingBinding(Key.get
                (PlayerFactory.class,
                 Names.named(input[1])));

        Player[] players =
                {
                bindingP1.getProvider().get().createPlayer("X"),
                bindingP2.getProvider().get().createPlayer("O")
                };

        String currentPlayer = null;
        System.out.println(map);
        while (!game.isFinished(map.getMap())) {
            for (Player player : players) {
                currentPlayer = player.getLabel();
                while (true) {
                    try {
                        System.out.println(player.getClass().getSimpleName() + " make a move:");
                        int[] move = player.getMove(map.getMap());
                        map.getMap()[move[0]][move[1]] = player.getLabel();
                        System.out.println(map);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (game.isFinished(map.getMap())) break;
            }
        }
        System.out.println(game.isWin(map.getMap(), currentPlayer) ? currentPlayer + " wins" : "tie");
    }
}

