package PasswordInputFieldValidation;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class PasswordValidationTests {

    PasswordValidation passwordValidation;
    @Before
    public void setUp() throws Exception{
        passwordValidation = new PasswordValidation();
    }
    @Test
    public void checkMethodTakesStringAsInput() throws Exception{
        passwordValidation.check("a");
    }

    @Test
    public void checkMethodRetrunsBoolean() throws Exception{
        boolean valid = passwordValidation.check("a");
    }

    @Test
    public void shouldHaveAtLeast8CharactersLong() throws Exception{
        boolean valid = passwordValidation.check("A-aaaaaaa88");
        boolean invalid = passwordValidation.check("aa");

        assertFalse(invalid);
        assertTrue(valid);
    }

    @Test
    public void shouldhave2orMoreNumbers() throws Exception{
        boolean valid = passwordValidation.check("A-aaaaaa88");
        boolean invalid = passwordValidation.check("aaaaaa8");

        assertFalse(invalid);
        assertTrue(valid);
    }

    @Test
    public void shouldHaveAtLeast1CapitalLetter() throws Exception{
        boolean valid = passwordValidation.check("A-aaaaaa88");
        boolean invalid = passwordValidation.check("aaaaaa8");

        assertTrue(valid);
        assertFalse(invalid);
    }

    @Test
    public void shouldHaveAtLeast1SpecialChar() throws Exception{
        boolean valid = passwordValidation.check("A-aaaaaa88");
        boolean invalid = passwordValidation.check("aaaaaa8");

        assertTrue(valid);
        assertFalse(invalid);
    }

    @Test
    public void correctPasswordReturns0ErrorMessage() throws Exception{
        boolean valid = passwordValidation.check("A-aaaaaa88");
        assertTrue(valid);
    }


}
