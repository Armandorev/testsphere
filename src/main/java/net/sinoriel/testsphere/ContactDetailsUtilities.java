package net.sinoriel.testsphere;

import java.io.IOException;
import java.util.List;

/**
 * Created by armandosanchezmedina on 13/11/2015.
 */
public class ContactDetailsUtilities {
    private static ContactDetailsUtilities contactDetailsUtilities;
    private static Person person;

    private List<String> listOfDomains;

    private ContactDetailsUtilities() throws IOException {
        listOfDomains = Utilities.giveMeTheListOf(Constants.DOMAINS_PROPERTIES_FILE);
    }

    public static ContactDetailsUtilities getContactDetailsUtilities() throws IOException {
        if (contactDetailsUtilities == null){
            contactDetailsUtilities = new ContactDetailsUtilities();
        }
        return contactDetailsUtilities;
    }

    private String giveMeADomain() throws WrongNumberException {
        return Utilities.giveMeARandomElementFromList(listOfDomains);
    }

    public String giveMeAnEmailByName(PersonalInformation personalInformation) throws WrongNumberException {
        String email = personalInformation.getCompleteName()+"@"+giveMeADomain();
        System.out.println("email for Person: "+email);
        return email;

    }
}
