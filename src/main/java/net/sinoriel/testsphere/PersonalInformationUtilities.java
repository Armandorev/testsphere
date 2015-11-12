package net.sinoriel.testsphere;

import java.util.List;

import static net.sinoriel.testsphere.Utilities.giveMeARandomElementFromList;
import static net.sinoriel.testsphere.Utilities.giveMeARandomNumberFrom1To;

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

    public Integer giveMeAnAge() throws WrongNumberException {
        Integer age = giveMeARandomNumberFrom1To(Constants.DEFAULT_MAX_AGE);
        System.out.println("Age for Person: "+ age);
        return age;
    }

    public Integer giveMeAnAgeFrom(int ageMin, int ageMax) throws WrongNumberException {
        Integer age = Utilities.giveMeARandomNumber(ageMin, ageMax);
        return age;
    }

    public Genders giveMeAGender() throws WrongNumberException {
        Integer randomNum = giveMeARandomNumberFrom1To(100);
        Genders gender = Genders.NOTPECIFIED;

        if (randomNum <= 55 ) {
            gender = Genders.FEMALE;
        } else {
            gender = Genders.MALE;
        }

        System.out.println("Gender for Person: "+ gender);
        return gender;

    }
}
