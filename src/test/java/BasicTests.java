import net.sinoriel.testsphere.utilities.Utilities;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class BasicTests {

    @Test
    public void shouldMaximizeToOneValuesGreaterThanOne(){
        double value = Utilities.maximizeToOne(2D);
        assertTrue("Should return 1 if value is greater than 1 and "+value+" was not converted.",
                value <= 1);
    }

    @Test
    public void shouldHaveAListOfNamesToUse() throws Exception {
        assertTrue("Names File should not be empty", Utilities.giveMeTheListOf("maleNames.txt").size() > 0);
    }

    @Test
    public void shouldHaveAListOfSurnamesToUse() throws Exception {
        assertTrue("Surames File should not be empty", Utilities.giveMeTheListOf("surnames.txt").size() > 0);
    }

    @Test
    public void shouldHaveAListOfDomainsToUse() throws Exception {
        assertTrue("Domains File should not be empty", Utilities.giveMeTheListOf("domains.txt").size() > 0);
    }

}
