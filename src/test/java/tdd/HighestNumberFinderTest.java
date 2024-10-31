package tdd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestNumberFinderTest
{
    @Test
    public void find_highest_in_array_of_one_expect_single_item()
    {
        // arrange
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 10;

        // act
        int actualResult = cut.findHighestNumber( input );

        //assert
        assertEquals (expectedResult, actualResult);
    }
    @Test
    public void find_highest_between_13_and_4()
    {

    }
}
