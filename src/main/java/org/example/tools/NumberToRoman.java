package org.example.tools;

import static org.example.constant.RomanNumber.*;

public class NumberToRoman {
    public String convertNumber(int number) {
        String thousands = writeThousands(number);
        String decades = writeDecades(number);
        String units = writeUnits(number);
        return thousands + decades + units;
    }

    private String writeUnits(int number) {
        int units = number % 10;
        if (units == 9) {
            return NINE_IN_ROMAN;
        }

        if (units >= 5) {
            return FIVE_IN_ROMAN + repeatedLetter(ONE_IN_ROMAN, units, 5);
        }

        if (units == 4) {
            return FOUR_IN_ROMAN;
        }

        return repeatedLetter(ONE_IN_ROMAN, units, 5);
    }

    private String writeDecades(int number) {
        int lastTwoDigits;

        if (number >= 100) {
            lastTwoDigits = number % 100;
        } else {
            lastTwoDigits = number;
        }

        if (lastTwoDigits >= 90) {
            return NINETY_IN_ROMAN;
        }

        if (lastTwoDigits >= 50) {
            return FIFTY_IN_ROMAN + repeatedLetter(TEN_IN_ROMAN, lastTwoDigits, 50, 10);
        }

        if (lastTwoDigits >= 40) {
            return FORTY_IN_ROMAN;
        }
        return repeatedLetter(TEN_IN_ROMAN, lastTwoDigits, 0, 10);
    }

    private String writeThousands(int number) {

        int restAfterThousands = number % 1000;
        String thousands = THOUSAND_IN_ROMAN.repeat(Math.max(0, number / 1000));
        if (restAfterThousands >= 900) {
            return thousands + NINE_HUNDRED_IN_ROMAN;
        }

        if (restAfterThousands >= 500) {
            int hundredAfter500 = (restAfterThousands - 500) / 100;
            String hundred = thousands + FIVE_HUNDRED_IN_ROMAN;
            hundred += repeatedLetter(ONE_HUNDRED_IN_ROMAN, hundredAfter500, 0);
            return hundred;
        }

        if (restAfterThousands >= 400) {
            return thousands + FOUR_HUNDRED_IN_ROMAN;
        }

        if (restAfterThousands >= 100) {
            int hundredAfter100 = (restAfterThousands) / 100;
            return thousands + repeatedLetter(ONE_HUNDRED_IN_ROMAN, hundredAfter100, 0);
        }
        return thousands;
    }

    private String repeatedLetter(String roman, int units, int numberToSubstract) {
        return repeatedLetter(roman, units, numberToSubstract, 1);
    }

    private String repeatedLetter(String roman, int units, int numberToSubstract, int divideBy) {
        return roman.repeat(Math.max(0, (units - numberToSubstract) / divideBy));
    }
}
