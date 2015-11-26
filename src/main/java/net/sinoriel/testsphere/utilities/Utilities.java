package net.sinoriel.testsphere.utilities;

import net.sinoriel.testsphere.exceptions.WrongNumberException;
import net.sinoriel.testsphere.repository.Constants;
import net.sinoriel.testsphere.repository.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class Utilities {


    public static List<String> giveMeTheListOf(String fileName) throws IOException {
        File file;
        file = new File(Utilities.class.getClassLoader().getResource(fileName).getFile());
        if (!file.exists()) {
            System.out.println("Couldnt Find File on System.");
            return new ArrayList<String>();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> results = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            results.add(line);
            line = reader.readLine();
        }
        return results;
    }

    public static String giveMeARandomElementFromList(List<String> myList) throws WrongNumberException {
        return myList.get(giveMeARandomNumberFrom1To(myList.size()));
    }

    public static Country giveMeARandomElementFromCountries(List<Country> myList) throws WrongNumberException {
        return myList.get(giveMeARandomNumberFrom1To(myList.size()));
    }

    public static int giveMeARandomNumberFrom1To(Integer value) throws WrongNumberException {

        int randomNumber = 0;
        if (value >0 && value != null ) {
            randomNumber = (int) (Math.random() * (value-1) + 1);
        }
        else {
            throw new WrongNumberException("Number not valid for generating our Testsphere Random value from 1 to |"+value+"|");
        }
        System.out.println("Giving a Random Number from 1 to "+value+ ": "+randomNumber);
        return randomNumber;
    }
    public static int giveMeARandomNumber(Integer min,Integer max) throws WrongNumberException {

        int value = max-min;
        int randomNumber = 0;
        if (value >0) {
            randomNumber = (int) (Math.random() * (value-1) + 1);
        }
        else {
            throw new WrongNumberException("Number not valid for generating our Testsphere Random value from "+min+" to "+max);
        }
        System.out.println("Giving a Random Number from "+min+" to "+max+ ": "+randomNumber);
        return randomNumber+min;
    }

    public static double maximizeToOne(Double value){
        if (value > 1D ) value = 1D;
        return value;
    }

    public static List<Country> giveMeTheListOfCountries() throws IOException {
        File file;
        file = new File(Utilities.class.getClassLoader().getResource(Constants.CONTRIES_PROPERTIES_FILE).getFile());
        if (!file.exists()) {
            System.out.println("Couldnt Find File on System.");
            return new ArrayList<Country>();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Country> results = new ArrayList<Country>();
        String line = reader.readLine();
        while (line != null) {
            Country currentcountry = new Country();
            String[] countryParts = line.split("\\;");
            currentcountry.setName(countryParts[0]);
            currentcountry.setTwoCharName(countryParts[1]);
            currentcountry.setThreeCharName(countryParts[2]);
            currentcountry.setPhonePrefix(countryParts[3]);
            line = reader.readLine();
            results.add(currentcountry);
        }
        return results;
    }

    public static Boolean checkIfElementOnList(String element, List<String> listOfElements) {
        return listOfElements.contains(element);
    }

    public static void addValue(StringBuilder stringBuilder, String title, String value) {
        stringBuilder.append(title).append(": ").append(value).append(System.lineSeparator());
    }
}
