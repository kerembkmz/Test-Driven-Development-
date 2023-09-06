package PointOfSale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class PointOfSaleTests {
    PointOfSale pointOfSale;
    @Before
    public void SetUp() throws Exception{
        pointOfSale = new PointOfSale();

    }

    @Test
    public void scansNumbers() throws Exception{
        pointOfSale.scan("12345");
    }

    @Test
    public void certainScansReturnCertainNumbers() throws Exception{
        String price = pointOfSale.scan("12345");
        assertEquals(price, "$7.25");
    }

    @Test
    public void certainScansReturnCertainNumbers2() throws Exception{
        String price = pointOfSale.scan("23456");
        assertEquals(price, "$12.5");
    }

    @Test
    public void barcodeNotFound() throws Exception{
        String price = pointOfSale.scan("99999");
        assertEquals(price, "Error: barcode not found");
    }
    @Test
    public void EmptyBarcode() throws Exception{
        String price = pointOfSale.scan("");
        assertEquals(price, "Error: empty barcode");
    }

    @Test
    public void multipleBarcodesReturnTheTotalAmount() throws Exception{

        String price = pointOfSale.scanTotal(new String[]{"12345", "23456"});
        assertEquals(price, "Total Is: $19.75");
    }
}
