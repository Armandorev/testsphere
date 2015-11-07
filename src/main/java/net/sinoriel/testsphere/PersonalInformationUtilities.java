package net.sinoriel.testsphere;

import java.util.List;

import static net.sinoriel.testsphere.Utilities.giveMeARandomElementFromList;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformationUtilities {

    private static PersonalInformationUtilities personalInformationUtilities;

    private List<String> listOfNames;

    private PersonalInformationUtilities() throws Exception {
        listOfNames = Utilities.giveMeTheListOf("names.properties");
    }

    public static PersonalInformationUtilities getPersonalInformationUtilities() throws Exception {
        if (personalInformationUtilities == null){
            personalInformationUtilities = new PersonalInformationUtilities();
        }
        return personalInformationUtilities;

    }
    public String giveMeAName() throws WrongNumberException {
        String nameToReturn = giveMeARandomElementFromList(listOfNames);
        System.out.println("Name for Person: "+nameToReturn);
        return nameToReturn;
    }
}
