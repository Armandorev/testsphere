package net.sinoriel.testsphere;
import net.sinoriel.testsphere.PersonalInformation;

/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class Person {
    private PersonalInformation personalInformation;
    private ContactDetails contactDetails;

    public Person(PersonBuilder builder) throws Exception {
        personalInformation = builder.personalInformation;
        contactDetails = builder.contactDetails;
    }


    public static class PersonBuilder{
        private PersonalInformation personalInformation;
        private ContactDetails contactDetails;

        public PersonBuilder() throws Exception {
            // The default builder doesnt include now anything appart from personal Information, as it was causing other objects depending on it to be not receiving specific data
            this.personalInformation = new PersonalInformation.PersonalInformationBuilder().build();
            //this.contactDetails = new ContactDetails.ContactDetailsBuilder().build();
        }

        public PersonBuilder withPersonalInformation(PersonalInformation personalInformation){
            this.personalInformation = personalInformation;
            return this;
        }

        public PersonBuilder withContactDetails(ContactDetails contactDetails){
            this.contactDetails = contactDetails;
            return this;
        }

        public PersonBuilder withContactDetails() throws Exception {
            this.contactDetails = new ContactDetails.ContactDetailsBuilder().build();
            return this;
        }

        public Person build() throws Exception {
            return new Person(this);
        }
    }
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }
    public ContactDetails getContactDetails() { return contactDetails; }

}
