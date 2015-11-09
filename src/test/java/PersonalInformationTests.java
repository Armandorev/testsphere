import net.sinoriel.testsphere.Person;
import net.sinoriel.testsphere.PersonalInformation;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonalInformationTests {

    @Test
    public void shouldGeneratePersonWithPersonalInformation() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertNotNull(personGenerated.getPersonalInformation());
        //assert("empty string", isEmptyOrNullString(), "");
        assertTrue("Personal Information should have a name but was empty.", personGenerated.getPersonalInformation().getName().length() > 0);
        assertTrue("Personal Information should have a surname but was empty.", personGenerated.getPersonalInformation().getSurname().length() > 0);
    }

    @Test
    public void shouldHaveAMiddleNameIfProbabilitySetTo100() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withPersonalInformation(new PersonalInformation.PersonalInformationBuilder()
                                .withMiddleName(1D).build()
                ).build();
        assertNotNull(personGenerated.getPersonalInformation());
        assertTrue("Personal Information should have a middle name but was empty.", personGenerated.getPersonalInformation().getMiddleName().length() > 0);
    }

    @Test
    public void shouldHaveSpecifiedName() throws Exception {
        String name = "TestName";
        Person personGenerated = new Person.PersonBuilder().withPersonalInformation(
                new PersonalInformation.PersonalInformationBuilder().withName(name).build()
        ).build();
        assertEquals(personGenerated.getPersonalInformation().getName(), name);
    }

    @Test
    public void shouldHaveSpecifiedSurname() throws Exception {
        String surname = "TestSurname";
        Person personGenerated = new Person.PersonBuilder().withPersonalInformation(
                new PersonalInformation.PersonalInformationBuilder().withSurname(surname).build()
        ).build();
        assertEquals(personGenerated.getPersonalInformation().getSurname(), surname);
    }

    @Test
    public void shouldHaveSpecifiedMiddleName() throws Exception {
        String middleName = "TestMiddlename";
        Person personGenerated = new Person.PersonBuilder().withPersonalInformation(
                new PersonalInformation.PersonalInformationBuilder().withMiddleName(middleName).build()
        ).build();
        assertEquals(personGenerated.getPersonalInformation().getMiddleName(), middleName);
    }
}