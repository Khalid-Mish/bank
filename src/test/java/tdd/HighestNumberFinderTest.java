package tdd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HighestNumberFinderTest {
    @Test
    public void find_highest_in_array_of_one_expect_single_item() {
        // arrange
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 10;

        // act
        int actualResult = cut.findHighestNumber(input);

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_highest_between_13_and_4() {
        // Arrange
        int input[] = {13, 4};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 13;

        // Act
        int actualResult = cut.findHighestNumber(input);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_highest_in_array_with_negative_numbers() {
        // Arrange
        int input[] = {-5, -1, -10, -3};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = -1; // Highest among negative numbers

        // Act
        int actualResult = cut.findHighestNumber(input);

        // Assert
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void find_highest_in_empty_array_should_throw_exception() {
        // Arrange
        int input[] = {};
        HighestNumberFinder cut = new HighestNumberFinder();

        // Act
        try {
            cut.findHighestNumber(input);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Array must not be empty", e.getMessage());


            // Verify highest

            // find highest in array if several equal and max
        }
    }
}