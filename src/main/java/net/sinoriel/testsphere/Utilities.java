package net.sinoriel.testsphere;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
}
