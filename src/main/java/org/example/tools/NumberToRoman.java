package org.example.tools;

public class NumberToRoman {


    public String convertNumber(int number) {
        String thousands = writeThousands(number);
        String decades = writeDecades(number);
        String units = writeUnits(number);
        return thousands + decades + units;
    }

    private String writeUnits(int number) {
        int units = number%10;

        if (units == 9){
            return "IX";
        }

        if (units >= 5){
            return "V" + "I".repeat(Math.max(0, units-5));
        }

        if (units >= 4){
            return "IV";
        }

        return  "I".repeat(Math.max(0, units));
    }

    private String writeDecades(int number) {
        int lastTwoDigits;

        if (number >= 100) {
            lastTwoDigits = number % 100;
        } else {
            lastTwoDigits = number;
        }

        if (lastTwoDigits >= 90){
            return "XC";
        }

        if (lastTwoDigits >= 50){
            return "L" + "X".repeat(Math.max(0, (lastTwoDigits-50) / 10));
        }

        if (lastTwoDigits >=40){
            return "XL";
        }
        return "X".repeat(Math.max(0, (lastTwoDigits) / 10));
    }

    private  String writeThousands(int number){

        int restAfterThousands = number % 1000;
        String thousands = "M".repeat(Math.max(0, number / 1000));
        if (restAfterThousands >= 900){
            return thousands + "CM";
        }

        if (restAfterThousands >= 500){
            int hundredAfter500 = (restAfterThousands-500)/100;
            String hundred = thousands + "D";
            hundred += "C".repeat(Math.max(0, hundredAfter500));
            return hundred;
        }

        if (restAfterThousands >= 400){
            return thousands + "CD";
        }

        if (restAfterThousands >= 100){
            int hundredAfter100 = (restAfterThousands)/100;
            return thousands + "C".repeat(hundredAfter100);
        }
        return thousands;
    }
}
