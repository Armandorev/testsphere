package net.sinoriel.testsphere;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;
    private String surname;
    private String middleName;

    public PersonalInformation(double probabilityOfMiddleName) throws Exception {
        this.name = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAName();
        this.surname = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeASurname();
        this.middleName = maybeAMiddleName(probabilityOfMiddleName);
    }

    private String maybeAMiddleName(double probabilityOfMiddleName) throws Exception {
        double probability = Utilities.giveMeARandomNumberFrom1To(100);
        if ((probability/100) <=  (100/probabilityOfMiddleName)){
            return PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAMiddleName();
        }else{
            return "";
        }
    }


    public PersonalInformation() throws Exception {
        this(Constants.DEFAULT_PROBABILITY_FOR_MIDDLE_NAMES);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }
}
