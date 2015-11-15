package net.sinoriel.testsphere;
import net.sinoriel.testsphere.PersonalInformation;

/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class Person {
    private static PersonalInformation personalInformation;
    private static ContactDetails contactDetails;

    public Person(PersonBuilder builder) throws Exception {
        this.personalInformation = builder.personalInformation;
        this.contactDetails = builder.contactDetails;
    }


    public static class PersonBuilder{
        private PersonalInformation personalInformation;
        private ContactDetails contactDetails;

        public PersonBuilder() throws Exception {
            this.personalInformation = new PersonalInformation.PersonalInformationBuilder().build();
            this.contactDetails = new ContactDetails.ContactDetailsBuilder(this.personalInformation).build();
        }

        public PersonBuilder withPersonalInformation(PersonalInformation personalIformation){
            this.personalInformation = personalIformation;
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
