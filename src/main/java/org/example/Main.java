package org.example;
import org.example.tools.Conversion;
import org.example.tools.NumberToRoman;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();

        Conversion conversion = new Conversion();
        NumberToRoman numberToRoman = new NumberToRoman();
        int number = conversion.askNumberToConvert();
        String finalRomanNumber = numberToRoman.convertNumber(number);
        logger.info(finalRomanNumber);
    }
}