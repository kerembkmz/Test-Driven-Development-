package SearchFunctionality;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class SearchFunctionalityTests {

    SearchFunctionality searchFunctionality;
    @Before
    public void SetUp() throws Exception{
        searchFunctionality = new SearchFunctionality();
    }

    @Test
    public void SearchMethod_TakesStringAsInput() throws Exception{
        searchFunctionality.search("Istanbul");
    }

    @Test
    public void cityLengthLessThen2_returnsNull() throws Exception{
        String returnString = searchFunctionality.search("a");
        assertEquals(returnString, null);
    }

    @Test
    public void startingChars_willReturnCorrelatedCities() throws Exception{
        String returnString = searchFunctionality.search("va");
        assertEquals(returnString, "Vancouver Valencia");
    }

    @Test
    public void caseInsensitiveSearch() throws Exception{
        String returnString = searchFunctionality.search("vA");
        assertEquals(returnString, "Vancouver Valencia");
    }

    @Test
    public void middleChars_willReturnCorrelatedCities() throws Exception{
        String returnString = searchFunctionality.search("ape");
        assertEquals(returnString, "Budapest");
    }

    @Test
    public void asteriskChar_asSearchKey() throws Exception{
        String returnString = searchFunctionality.search("*");
        assertEquals(returnString, "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul");
    }
}
