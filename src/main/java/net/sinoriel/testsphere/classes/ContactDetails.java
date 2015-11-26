package net.sinoriel.testsphere.classes;

import net.sinoriel.testsphere.repository.DataRepository;
import net.sinoriel.testsphere.utilities.ContactDetailsUtilities;

import static net.sinoriel.testsphere.utilities.Utilities.addValue;

/**
 * Created by armandosanchezmedina on 13/11/2015.
 */
public class ContactDetails {

    private String email;

    public ContactDetails(ContactDetailsBuilder builder){
        this.email = builder.email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        StringBuilder contactDetails = new StringBuilder();
        addValue(contactDetails, "e-mail", email);
        return contactDetails.toString();
    }

    public static class ContactDetailsBuilder {
        private String email;

        public ContactDetailsBuilder() throws Exception {
            this.email = ContactDetailsUtilities.getContactDetailsUtilities().giveMeAnEmailByName(DataRepository.currentPersonalInformation);
        }

        public ContactDetailsBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }
}
