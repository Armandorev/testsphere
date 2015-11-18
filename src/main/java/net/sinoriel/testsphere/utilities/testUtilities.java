package net.sinoriel.testsphere.utilities;

import net.sinoriel.testsphere.repository.Genders;

/**
 * Created by armandosanchezmedina on 18/11/2015.
 */
public class testUtilities {
    public static Boolean isNameOnGender(String name, Genders gender) throws Exception {
        if (gender == Genders.MALE){
            return Utilities.checkIfElementOnList(name,PersonalInformationUtilities.getPersonalInformationUtilities().getListOfMaleNames());
        }
        else{
            return Utilities.checkIfElementOnList(name,PersonalInformationUtilities.getPersonalInformationUtilities().getListOfFemaleNames());
        }
    }
}
