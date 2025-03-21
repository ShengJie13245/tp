package bookkeeper;

import bookkeeper.exceptions.IncorrectFormatException;

public class InputParser {

    public static String[] extractCommandArgs(String input) throws IncorrectFormatException {
        String[] commandArgs = input.trim().split(" ", 2);
        if (commandArgs.length < 1) {
            throw new IncorrectFormatException("Invalid command format. Expected: COMMAND [ARGUMENTS]");
        }
        return commandArgs;
    }

    public static String[] extractAddBookArgs(String input) throws IncorrectFormatException {
        String[] commandArgs = new String[4];
        String[] splitInput = input.trim().split("( a/)|( cat/)|( cond/)", 4);

        if (splitInput.length != 4) {
            throw new IncorrectFormatException("Invalid format for add-book. " +
                    "Expected format: add-book BOOK_TITLE a/AUTHOR cat/CATEGORY cond/CONDITION");
        }

        for (int i = 0; i < splitInput.length; i++) {
            if (splitInput[i].isBlank()) {
                throw new IncorrectFormatException("Invalid format for add-book. " +
                        "Expected format: add-book BOOK_TITLE a/AUTHOR cat/CATEGORY cond/CONDITION");
            }
            commandArgs[i] = splitInput[i].trim();
        }

        return commandArgs;
    }

    /**
     * Extracts the arguments for the add-loan command.
     * <p>
     * The expected input format is: BOOK_TITLE n/BORROWER_NAME d/RETURN_DATE
     * Example: "The Great Gatsby n/John Doe d/2023-12-01"
     *
     * @param input The user input for the add-loan command.
     * @return An array of strings containing the arguments for the add-loan command:
     *      [0] - Book title
     *      [1] - Borrower's name
     *      [2] - Return date
     * @throws IncorrectFormatException if the input format is invalid.
     */
    public static String[] extractAddLoanArgs(String input) throws IncorrectFormatException {
        String[] commandArgs = new String[3];
        String[] splitInput = input.trim().split("( n/)|( d/)", 3);

        if (splitInput.length != 3) {
            throw new IncorrectFormatException("Invalid format for add-loan. " +
                    "Expected format: add-loan BOOK_TITLE n/BORROWER_NAME d/RETURN_DATE");
        }

        for (int i = 0; i < splitInput.length; i++) {
            if (splitInput[i].isBlank()) {
                throw new IncorrectFormatException("Invalid format for add-loan. " +
                        "Expected format: add-loan BOOK_TITLE n/BORROWER_NAME d/RETURN_DATE");
            }
            commandArgs[i] = splitInput[i].trim();
        }

        return commandArgs;
    }

    /**
     * Extracts the arguments for the delete-loan command.
     * <p>
     * The expected input format is: BOOK_TITLE n/BORROWER_NAME
     * Example: "The Great Gatsby n/John Doe"
     *
     * @param input The user input for the delete-loan command.
     * @return An array of strings containing the arguments for the add-loan command:
     *      [0] - Book title
     *      [1] - Borrower's name
     * @throws IncorrectFormatException if the input format is invalid.
     */
    public static String[] extractDeleteLoanArgs(String input) throws IncorrectFormatException {
        String[] commandArgs = new String[2];
        String[] splitInput = input.trim().split("( n/)", 2);
        if (splitInput.length < 2) {
            throw new IncorrectFormatException("Invalid format for delete-loan. " +
                    "Expected format: delete-loan BOOK_TITLE n/BORROWER_NAME");
        }

        for (int i = 0; i < splitInput.length; i++) {
            if (splitInput[i].isBlank()) {
                throw new IncorrectFormatException("Invalid format for delete-loan. " +
                        "Expected format: delete-loan BOOK_TITLE n/BORROWER_NAME");
            }
            commandArgs[i] = splitInput[i].trim();
        }

        return commandArgs;
    }
}
