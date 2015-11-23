import net.sinoriel.testsphere.repository.Constants;
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
    public void shouldHaveAListOfMaleNamesToUse() throws Exception {
        assertTrue("Names File should not be empty", Utilities.giveMeTheListOf(Constants.MALE_NAMES_PROPERTIES_FILE).size() > 0);
    }

    @Test
    public void shouldHaveAListOfFemaleNamesToUse() throws Exception {
        assertTrue("Names File should not be empty", Utilities.giveMeTheListOf(Constants.FEMALE_NAMES_PROPERTIES_FILE).size() > 0);
    }

    @Test
    public void shouldHaveAListOfSurnamesToUse() throws Exception {
        assertTrue("Surames File should not be empty", Utilities.giveMeTheListOf(Constants.SURNAMES_PROPERTIES_FILE).size() > 0);
    }

    @Test
    public void shouldHaveAListOfDomainsToUse() throws Exception {
        assertTrue("Domains File should not be empty", Utilities.giveMeTheListOf(Constants.DOMAINS_PROPERTIES_FILE).size() > 0);
    }

    @Test
    public void shouldHaveAListOfCountries() throws Exception {
        assertTrue("Countries File should not be empty", Utilities.giveMeTheListOfCountries().size() > 0);
    }

    @Test

}
