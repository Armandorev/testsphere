package net.sinoriel.testsphere;

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

    public static class ContactDetailsBuilder {
        private String email;

        public ContactDetailsBuilder(PersonalInformation personalInformation) throws Exception {
            this.email = ContactDetailsUtilities.getContactDetailsUtilities().giveMeAnEmailByName(personalInformation);
        }

        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }
}
