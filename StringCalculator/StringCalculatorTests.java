package StringCalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTests {

    StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception{
        stringCalculator = new StringCalculator();
    }


    @Test
    public void stringCalculator_hasMethodAddWithStringInput() throws Exception {
        stringCalculator.add("");
    }

    @Test
    public void AddMethod_UsingEmptyString() throws Exception {
        int returnValue = stringCalculator.add("");
        assertEquals(returnValue , 0);
    }

    @Test
    public void AddMethod_usingOneInteger() throws Exception{
        int returnValue = stringCalculator.add("1");
        assertEquals(returnValue, 1);
    }

    @Test
    public void AddMethod_usingTwoIntegers() throws Exception{
        int returnValue = stringCalculator.add("1,2");
        assertEquals(returnValue, 3);
    }

    @Test
    public void AddMethod_usingRandomNumberOfIntegers() throws  Exception{
        int returnValue = stringCalculator.add("1,2,3,4,5");
        assertEquals(returnValue, 15);
    }

    @Test
    public void handleNewlinesAsSeperators() throws Exception{
        int returnValue = stringCalculator.add("1,2\n3");
        assertEquals(returnValue, 6);
    }

    @Test
    public void invalidStringReturnsMinusOneMeaningErrorEccored() throws Exception{
        int returnValue = stringCalculator.add("2,\n3");
        assertEquals(returnValue,-1);
    }

    @Test
    public void separatorNotAllowedAtTheEndOfTheString() throws Exception{
        int returnValue = stringCalculator.add("1,2,");
        assertEquals(returnValue, -1);
    }

    @Test
    public void handleDifferentDelimitersType1() throws Exception {
        int returnValue = stringCalculator.add("//;\n1;3");
        assertEquals(returnValue, 4);
    }

    @Test
    public void moreThenOneDelimiterReturnsError() throws Exception{
        int returnValue = stringCalculator.add("//;\n1;3a4");
        assertEquals(returnValue, -1);
    }

    @Test
    public void negativeInputsShouldDetectError() throws Exception{
        int returnValue = stringCalculator.add("1,-2");
        assertEquals(returnValue, -1);
    }

    @Test
    public void multipleNegativeInputsShouldReturnWithErrorMessage() throws Exception{
        int returnValue = stringCalculator.add("2,-4,-9");
        assertEquals(returnValue,-1);
    }

    @Test
    public void callingAddWithMoreThenOneError_DisplaysBothErrors() throws Exception{
        int returnvalue = stringCalculator.add("//|\n1|2,-3");
        assertEquals(returnvalue, -1);
    }

    @Test
    public void addingNumberBiggerThen1000_ShouldBeIgnored() throws Exception{
        int returnValue = stringCalculator.add("2,1001");
        assertEquals(returnValue, 2);
    }


}
