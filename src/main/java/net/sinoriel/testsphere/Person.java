package net.sinoriel.testsphere;
import net.sinoriel.testsphere.PersonalInformation;

/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class Person {
    private PersonalInformation personalInformation;

    public Person(PersonBuilder builder) throws Exception {
        this.personalInformation = builder.personalInformation;
    }

    public static class PersonBuilder{
        private PersonalInformation personalInformation;

        public PersonBuilder() throws Exception {
            this.personalInformation = new PersonalInformation.PersonalInformationBuilder().build();
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

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
}
