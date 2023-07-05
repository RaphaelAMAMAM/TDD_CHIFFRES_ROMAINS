package org.example.tools;

import org.example.exception.NotBetweenOneAndTroisMille;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Conversion {

    public static final String ERROR_NOT_A_NUMBER_RETRY = "Not a number, retry";
    public static final String ERROR_NOT_BETWEEN_1_AND_3000 = "Not between 1 and 3000";
    static Logger logger = Logger.getAnonymousLogger();
    static Scanner scanner = new Scanner(System.in);


    public int askNumberToConvert() {
        logger.info("Put a number between 1 and 3000 -> ");
        while (true) {
            try {
                int number = scanner.nextInt();
                return numberToConvert(number);
            } catch (InputMismatchException e)  {
                logger.severe(ERROR_NOT_A_NUMBER_RETRY);
            } catch ( NotBetweenOneAndTroisMille e) {
                logger.severe(ERROR_NOT_BETWEEN_1_AND_3000);
            } finally {
                scanner.nextLine();
            }
        }
    }

    public int numberToConvert(int number) throws NotBetweenOneAndTroisMille {
        if (!isBetweenOneAndTroisMille(number)) {
            throw new NotBetweenOneAndTroisMille(ERROR_NOT_BETWEEN_1_AND_3000);
        }
        return number;
    }

    private boolean isBetweenOneAndTroisMille(int number) {
        return number > 0 && number <= 3000;
    }

}
