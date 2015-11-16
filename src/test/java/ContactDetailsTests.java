import net.sinoriel.testsphere.ContactDetails;
import net.sinoriel.testsphere.Person;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by armandosanchezmedina on 13/11/2015.
 */
public class ContactDetailsTests {

    public static final String TEST_EMAIL_COM = "test@email.com";

    @Test
    public void shouldGeneratePersonWithContactDetails() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertNotNull(personGenerated.getContactDetails());
        }

    @Test
    public void shouldGeneratePersonWithEmail() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertThat("Person should have email", personGenerated.getContactDetails().getEmail().length() > 0);
    }

    @Test
    public void shouldGeneratePersonWithGivenEmail() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withContactDetails(new ContactDetails.ContactDetailsBuilder().withEmail(TEST_EMAIL_COM).build()).build();
        assertEquals(personGenerated.getContactDetails().getEmail(), TEST_EMAIL_COM);
    }
}
