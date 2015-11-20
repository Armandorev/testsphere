package net.sinoriel.testsphere.utilities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.sinoriel.testsphere.repository.Constants;
import net.sinoriel.testsphere.repository.Country;
import net.sinoriel.testsphere.repository.Genders;
import net.sinoriel.testsphere.exceptions.WrongNumberException;

import java.util.List;

import static net.sinoriel.testsphere.utilities.Utilities.giveMeARandomElementFromCountries;
import static net.sinoriel.testsphere.utilities.Utilities.giveMeARandomElementFromList;
import static net.sinoriel.testsphere.utilities.Utilities.giveMeARandomNumberFrom1To;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformationUtilities {

    private static PersonalInformationUtilities personalInformationUtilities;

    private static List<String> listOfMaleNames;
    private static List<String> listOfFemaleNames;
    private static List<String> listOfSurnames;
    private static List<Country> listOfNationalities;


    public List<String> getListOfSurnames() {
        return listOfSurnames;
    }

    public List<String> getListOfFemaleNames() {
        return listOfFemaleNames;
    }

    public List<String> getListOfMaleNames() {
        return listOfMaleNames;
    }

    private PersonalInformationUtilities() throws Exception {
        listOfMaleNames = Utilities.giveMeTheListOf(Constants.MALE_NAMES_PROPERTIES_FILE);
        listOfFemaleNames = Utilities.giveMeTheListOf(Constants.FEMALE_NAMES_PROPERTIES_FILE);
        listOfSurnames = Utilities.giveMeTheListOf(Constants.SURNAMES_PROPERTIES_FILE);
        listOfNationalities = Utilities.giveMeTheListOfCountries();
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

    public String giveMeAName(Genders gender) throws WrongNumberException {
        String nameToReturn = "";
        if (gender.equals(Genders.MALE)){
            nameToReturn = giveMeARandomElementFromList(listOfMaleNames);
        }else{
            nameToReturn = giveMeARandomElementFromList(listOfFemaleNames);
        }
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
        Genders gender = Genders.NOTSPECIFIED;

        if (randomNum <= 55 ) {
            gender = Genders.FEMALE;
        } else {
            gender = Genders.MALE;
        }

        System.out.println("Gender for Person: "+ gender);
        return gender;

    }

    public Country giveMeANationality() throws WrongNumberException {
        Country countryToReturn = giveMeARandomElementFromCountries(listOfNationalities);
        System.out.println("Nationality for Person: "+countryToReturn);
        return countryToReturn;
    }

    public static Country getCountryByISO2(String nationality) {
        for(Country country: listOfNationalities){
            if (country.getTwoCharName().equalsIgnoreCase(nationality)){
                return country;
            }
        }
        return new Country();
    }
}
