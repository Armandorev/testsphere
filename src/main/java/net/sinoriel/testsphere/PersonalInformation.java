package net.sinoriel.testsphere;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;
    private String surname;

    public PersonalInformation() throws Exception {
        this.name = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAName();
        this.surname = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeASurname();
    }

    public String getName() {
        return name;
    }
    public String getSurname() { return surname; }
}
