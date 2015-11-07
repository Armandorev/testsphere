package net.sinoriel.testsphere;
import net.sinoriel.testsphere.PersonalInformation;

/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class Person {
    private PersonalInformation personalInformation;

    public Person() throws Exception {
        this(Constants.DEFAULT_PROBABILITY_FOR_MIDDLE_NAMES);
    }

    public Person(double middleNameProbability) throws Exception {
        //Probability from 0 to 1
        Utilities.maximizeToOne(middleNameProbability);
        this.personalInformation = new PersonalInformation();

    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
}
