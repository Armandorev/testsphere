package net.sinoriel.testsphere;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;
    private String surname;
    private String middleName;

    public PersonalInformation(PersonalInformationBuilder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.middleName = builder.middleName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public static class PersonalInformationBuilder {
        private String name;
        private String surname;
        private String middleName;

        public PersonalInformationBuilder() throws Exception {
            this.name = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAName();
            this.surname = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeASurname();
            this.middleName = maybeAMiddleName(Constants.DEFAULT_PROBABILITY_FOR_MIDDLE_NAMES);
        }

        public PersonalInformationBuilder withName(String name){
            this.name = name;
            return this;
        }

        public PersonalInformationBuilder withSurname(String surname){
            this.surname = surname;
            return this;
        }

        public PersonalInformationBuilder withMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public PersonalInformationBuilder withMiddleName() throws Exception {
            this.middleName = PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAMiddleName();
            return this;
        }

        public PersonalInformationBuilder withMiddleName(double probability) throws Exception {
            this.middleName = maybeAMiddleName(probability);
            return this;
        }
        private String maybeAMiddleName(double probabilityOfMiddleName) throws Exception {
            Utilities.maximizeToOne(probabilityOfMiddleName);
            double probability = Utilities.giveMeARandomNumberFrom1To(100);
            if ((probability/100) <=  (100/probabilityOfMiddleName)){
                return PersonalInformationUtilities.getPersonalInformationUtilities().giveMeAMiddleName();
            }else{
                return "";
            }
        }

        public PersonalInformation build(){
            return new PersonalInformation(this);
        }


    }
}
