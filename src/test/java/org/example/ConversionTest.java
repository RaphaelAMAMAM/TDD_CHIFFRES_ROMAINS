package org.example;

import org.example.exception.NotBetweenOneAndTroisMille;
import org.example.tools.NumberToRoman;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ConversionTest {
    Conversion conversion = new Conversion();
    NumberToRoman numberToRoman = new NumberToRoman();

    @Test
    void numberBetween1And3000ReturnNumber() throws NotBetweenOneAndTroisMille {
        int number = 5;
        assertThat(conversion.numberToConvert(number)).isEqualTo(number);
    }

    @Test
    void numberBetween1And3000ThrowException() throws NotBetweenOneAndTroisMille {
        int number = 0;
        assertThatExceptionOfType(NotBetweenOneAndTroisMille.class).isThrownBy(() -> {
            conversion.numberToConvert(number);
        });
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/data-thousands-test.csv"})
    void convertNumberInRomanThousands(int actual, String roman) {
        assertThat(numberToRoman.convertNumber(actual)).isEqualTo(roman);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/data-decades-test.csv"})
    void convertNumberInRomanDecades(int actual, String roman) {
        assertThat(numberToRoman.convertNumber(actual)).isEqualTo(roman);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/data-units-test.csv"})
    void convertNumberInRomanUnits(int actual, String roman) {
        assertThat(numberToRoman.convertNumber(actual)).isEqualTo(roman);
    }
}