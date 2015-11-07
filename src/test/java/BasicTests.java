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

    }

    @Test
    public void shouldHaveAListOfNameToUse() throws Exception {
        assertTrue("Names File should not be empty", Utilities.giveMeTheListOf("maleNames.properties").size() > 0);
    }
}
