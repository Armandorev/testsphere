import net.sinoriel.testsphere.Person;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by armandosanchezmedina on 13/11/2015.
 */
public class ContactDetailsTests {
    @Test
    public void shouldGeneratePersonWithContactDetails() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertNotNull(personGenerated.getContactDetails());
        }
}
