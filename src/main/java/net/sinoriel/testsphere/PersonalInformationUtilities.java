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
        listOfMaleNames = Utilities.giveMeTheListOf("maleNames.txt");
        listOfSurnames = Utilities.giveMeTheListOf("surnames.txt");
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
}
