import net.sinoriel.testsphere.ContactDetails;
import net.sinoriel.testsphere.Person;
import net.sinoriel.testsphere.PersonalInformation;
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
        Person personGenerated = new Person.PersonBuilder().withContactDetails().build();
        assertNotNull(personGenerated.getContactDetails());
        }

    @Test
    public void shouldGeneratePersonWithEmail() throws Exception {
        Person personGenerated = new Person.PersonBuilder().withContactDetails().build();
        assertThat("Person should have email", personGenerated.getContactDetails().getEmail().length() > 0);
    }

    @Test
    public void shouldGeneratePersonWithGivenEmail() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withContactDetails(new ContactDetails.ContactDetailsBuilder().withEmail(TEST_EMAIL_COM).build()).build();
        assertEquals(personGenerated.getContactDetails().getEmail(), TEST_EMAIL_COM);
    }

    @Test
    public void shouldGenerateEmailBasedOnName() throws Exception {
        Person personGenerated = new Person.PersonBuilder().withPersonalInformation(
                new PersonalInformation.PersonalInformationBuilder().withName("Name").withSurname("Surname").withMiddleName("Middle").build()
        ).withContactDetails().build();
        String email = personGenerated.getContactDetails().getEmail();
        String[] emailParts = email.split("\\@");
        assertEquals(emailParts[0], "NameMiddleSurname");
    }
}
