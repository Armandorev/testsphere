import junit.framework.Assert;
import net.sinoriel.testsphere.repository.Ages;
import net.sinoriel.testsphere.repository.Constants;
import net.sinoriel.testsphere.classes.Person;
import net.sinoriel.testsphere.classes.PersonalInformation;
import net.sinoriel.testsphere.repository.Genders;
import net.sinoriel.testsphere.utilities.PersonalInformationUtilities;
import net.sinoriel.testsphere.utilities.testUtilities;
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
    public void shouldHaveAMiddleNameIfProbabilitySetTo1() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withPersonalInformation(new PersonalInformation.PersonalInformationBuilder()
                                .withMiddleName().build()
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

    @Test
    public void shouldIncludeDoubleSurnameIfProbabilitySetTo1() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withPersonalInformation(new PersonalInformation.PersonalInformationBuilder()
                                .withDoubleSurname().build()
                ).build();
        assertNotNull(personGenerated.getPersonalInformation());
        assertTrue("Personal Information should have a double surname but was single.", personGenerated.getPersonalInformation().getSurname().contains(" "));
    }

    @Test
    public void shouldIncludeAge() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertTrue("Personal Information should have a name but was empty.", personGenerated.getPersonalInformation().getAge() > 0);

    }

    @Test
    public void shouldIncludeSpecifiedAge() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withPersonalInformation(new PersonalInformation.PersonalInformationBuilder()
                        .withAge(35).build()).build();
        assertTrue("Personal Information should have specified age but was"+personGenerated.getPersonalInformation().getAge(), personGenerated.getPersonalInformation().getAge() == 35);


    }

    @Test
    public void shouldReturnAnAdult() throws Exception {
        Person personGenerated = new Person.PersonBuilder()
                .withPersonalInformation(new PersonalInformation.PersonalInformationBuilder()
                        .withAge(Ages.ADULT).build()).build();
        int age = personGenerated.getPersonalInformation().getAge();
        assertTrue("Person should be an adult", (age >= Constants.DEFAULT_AGE_ADULT_MIN && age <= Constants.DEFAULT_AGE_ADULT_MAX));

    }

    @Test
    public void shouldIncludeGender() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        assertNotNull("Personal Information should include gender.", personGenerated.getPersonalInformation().getGender());
    }

    @Test
    public void shouldReturnACompleteName() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        String personGeneratedCompleteName = personGenerated.getPersonalInformation().getCompleteName();
        String middlenametoReturn = personGenerated.getPersonalInformation().getMiddleName().length()>0?" "+personGenerated.getPersonalInformation().getMiddleName():"";
        String personGeneratedConcatenateName = personGenerated.getPersonalInformation().getName()
                + middlenametoReturn
                + " "+ personGenerated.getPersonalInformation().getSurname();
        assertTrue("Concatenated name should be valid", personGeneratedCompleteName.equals(personGeneratedConcatenateName));

    }

    @Test
    public void shouldGiveANameBasedOnGender() throws Exception {
        Person personGenerated = new Person.PersonBuilder().build();
        String name = personGenerated.getPersonalInformation().getName();
        Genders gender = personGenerated.getPersonalInformation().getGender();
        assertTrue("Name should depend on Gender", testUtilities.isNameOnGender(name, gender));
    }

}