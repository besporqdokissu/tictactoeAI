package players;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EasyAI implements Player {

    Random random;
    String label;

    public EasyAI(String label) {
        this.label = label;
        random = new Random();
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int[] getMove(String[][] map) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(700);
        while (true) {
            int first = random.nextInt(3);
            int second = random.nextInt(3);
            if (map[first][second].equals(" ")) {
                return new int[]{first, second};
            }
        }
    }
}
