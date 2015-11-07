package net.sinoriel.testsphere;

import java.util.List;

import static net.sinoriel.testsphere.Utilities.giveMeARandomElementFromList;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformationUtilities {

    private static PersonalInformationUtilities personalInformationUtilities;

    private List<String> listOfMaleNames;
    private List<String> listOfSurnames;

    private PersonalInformationUtilities() throws Exception {
        listOfMaleNames = Utilities.giveMeTheListOf(Constants.MALE_NAMES_PROPERTIES_FILE);
        listOfSurnames = Utilities.giveMeTheListOf(Constants.FEMALE_NAMES_PROPERTIES_FILE);
    }

    public static PersonalInformationUtilities getPersonalInformationUtilities() throws Exception {
        if (personalInformationUtilities == null){
            personalInformationUtilities = new PersonalInformationUtilities();
        }
        return personalInformationUtilities;

    }
    public String giveMeAName() throws WrongNumberException {
        String nameToReturn = giveMeARandomElementFromList(listOfMaleNames);
        System.out.println("Name for Person: "+nameToReturn);
        return nameToReturn;
    }
    public String giveMeASurname() throws WrongNumberException {
        String surnameToReturn = giveMeARandomElementFromList(listOfSurnames);
        System.out.println("Surname for Person: "+surnameToReturn);
        return surnameToReturn;
    }

    public String giveMeAMiddleName() throws WrongNumberException {
        String middleNameToReturn = giveMeARandomElementFromList(listOfMaleNames);
        System.out.println("Middle Name for Person: "+middleNameToReturn);
        return middleNameToReturn;
    }
}
