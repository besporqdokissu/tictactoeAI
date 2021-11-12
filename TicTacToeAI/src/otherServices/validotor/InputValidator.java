package otherServices.validotor;

public class InputValidator implements IValidator {

    public void validate(String[][] map, String input){
        if (!(Character.isDigit(input.charAt(0)) || Character.isDigit(input.charAt(2))))
            throw new IllegalArgumentException("You should enter numbers!\n");

        int anInt = Integer.parseInt(String.valueOf(input.charAt(0)));
        int anInt1 = Integer.parseInt(String.valueOf(input.charAt(2)));

        if (anInt > 3 || anInt1 > 3)
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!\n");

        if (!map[anInt - 1][anInt1 - 1].equals(" "))
            throw new IllegalArgumentException("This cell is occupied! Choose another one!\n");
    }
}



//    public void processInput(String[][] map, String input, String currentPlayer) {
//        inputAnalyzer(map, input);
//        map[Integer.parseInt(String.valueOf(input.charAt(0))) - 1]
//                [Integer.parseInt(String.valueOf(input.charAt(2))) - 1] = currentPlayer;
//    }
