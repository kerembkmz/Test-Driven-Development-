package FizzBuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class FizzBuzzTests {
    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception{
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void newObj_IsEmpty() throws Exception{
        assertTrue(fizzBuzz.isEmpty());
    }


    @Test
    public void hasAddMethod() throws Exception{
        fizzBuzz.add(1);
    }

    @Test
    public void addMethod_takesIntAsInteger() throws Exception{
        fizzBuzz.add(1);
    }

    @Test
    public void isEmpty_isWrongAfterAdd() throws Exception{
        fizzBuzz.add(1);
        assertFalse(fizzBuzz.isEmpty());
    }

    @Test
    public void addMethod_returnsString() throws Exception{
        String buzzString = fizzBuzz.add(1);
    }

    @Test
    public void addMethod_returnsCorrectString() throws Exception{
        String buzzString = fizzBuzz.add(1);
        assertEquals(buzzString, "1");
    }

    @Test
    public void addMethod_callingIt2Times() throws Exception{
        String buzzString1 = fizzBuzz.add(1);
        assertEquals(buzzString1, "1");
        String buzzString2 = fizzBuzz.add(2);
        assertEquals(buzzString2, "2");
    }

    @Test
    public void addMethod_withMultipleOfThree() throws Exception{
        String buzzString = fizzBuzz.add(3);
        assertEquals(buzzString, "Fizz");
    }

    @Test
    public void addMethod_withMultipleOfFive() throws Exception{
        String buzzString = fizzBuzz.add(5);
        assertEquals(buzzString, "Buzz");
    }

    @Test
    public void addMethod_multipleOfBothThreeAndFive() throws Exception{
        String buzzString = fizzBuzz.add(15);
        assertEquals(buzzString, "FizzBuzz");
    }



}
