import net.sinoriel.testsphere.Person;
import net.sinoriel.testsphere.Utilities;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class BasicTests {
    @Test
    public void shouldGeneratePerson() throws Exception {
        assertThat(new Person(), CoreMatchers.instanceOf(Person.class));
    }

    @Test
    public void shouldGeneratePersonWithPersonalInformation() throws Exception {
        Person personGenerated = new Person();
        assertNotNull(personGenerated.getPersonalInformation());
        //assert("empty string", isEmptyOrNullString(), "");
        assertTrue("Personal Information should have a name but was empty.",personGenerated.getPersonalInformation().getName().length()>0);
        assertTrue("Personal Information should have a surname but was empty.",personGenerated.getPersonalInformation().getSurname().length()>0);

    }

    @Test
    public void shouldHaveAListOfNamesToUse() throws Exception {
        assertTrue("Names File should not be empty", Utilities.giveMeTheListOf("maleNames.txt").size() > 0);
    }

    @Test
    public void shouldHaveAListOfSurnamesToUse() throws Exception {
        assertTrue("Surames File should not be empty", Utilities.giveMeTheListOf("surnames.txt").size() > 0);
    }

}
