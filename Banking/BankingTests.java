package Banking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class BankingTests {
    Banking banking;
    @Before
    public void setUp() throws Exception{
        banking = new Banking();
    }

    @Test
    public void printStatement() throws Exception{
        banking.printStatement();
    }

    @Test
    public void depositAndPrint() throws Exception{
        banking.deposit(500);
        banking.printStatement();

    }

    @Test
    public void withDrawAndPrint() throws Exception{
        banking.withdraw(300);
        banking.printStatement();
    }

    @Test
    public void depositAndWithDraw_ThenPrint() throws Exception{
        banking.deposit(1000);
        banking.deposit(500);
        banking.withdraw(100);
        banking.withdraw(500);
        banking.printStatement();
    }
}
