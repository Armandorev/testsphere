package net.sinoriel.testsphere;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;

    public PersonalInformation() throws Exception {
        this.name = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
