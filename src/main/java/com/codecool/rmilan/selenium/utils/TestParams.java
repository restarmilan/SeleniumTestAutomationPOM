package com.codecool.rmilan.selenium.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestParams {

    static Stream<Arguments> provideInputsForCheckboxTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("0", "0", "0", "0"), "Check All"),
                Arguments.of(Arrays.asList("0", "0", "0", "1"), "Check All"),
                Arguments.of(Arrays.asList("0", "0", "1", "1"), "Check All"),
                Arguments.of(Arrays.asList("0", "1", "0", "1"), "Check All"),
                Arguments.of(Arrays.asList("0", "1", "1", "1"), "Check All"),
                Arguments.of(Arrays.asList("1", "1", "1", "1"), "Uncheck All")
        );
    }
}
