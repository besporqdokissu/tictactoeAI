package players;

import otherServices.validotor.IValidator;

import java.util.Scanner;

public class User implements Player {
    private final IValidator validator;
    private final Scanner scanner;
    private final String actuallyChar;

    public User(IValidator validator, String actuallyChar) {
        this.validator = validator;
        this.actuallyChar = actuallyChar;
        scanner = new Scanner(System.in);
    }


    public int[] getMove(String[][] field) {
        String input = scanner.nextLine();
        validator.validate(field, input);
        return new int[]{(Integer.parseInt(String.valueOf(input.charAt(0))))-1, (Integer.parseInt(String.valueOf(input.charAt(2))))-1};
    }

    public String getLabel() {
        return actuallyChar;
    }
}
