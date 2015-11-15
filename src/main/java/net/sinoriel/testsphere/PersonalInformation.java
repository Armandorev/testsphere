package net.sinoriel.testsphere;

import static net.sinoriel.testsphere.PersonalInformationUtilities.*;
import static net.sinoriel.testsphere.Utilities.*;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;
    private String surname;
    private String middleName;
    private Integer age;
    private Genders gender;


    public PersonalInformation(PersonalInformationBuilder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.middleName = builder.middleName;
        this.age = builder.age;
        this.gender = builder.gender;
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

    public Integer getAge() { return age; }

    public Genders getGender() { return gender;}

    public String getCompleteName() {
        String middlenametoReturn = middleName.length()>0?" "+middleName:"";
        return name+middlenametoReturn+" "+surname;
    }

    public static class PersonalInformationBuilder {
        private String name;
        private String surname;
        private String middleName;
        private Integer age;
        private Genders gender;

        public PersonalInformationBuilder() throws Exception {
            this.name = getPersonalInformationUtilities().giveMeAName();
            this.surname = getPersonalInformationUtilities().giveMeASurname();
            this.middleName = maybeAMiddleName(Constants.DEFAULT_PROBABILITY_FOR_MIDDLE_NAMES);
            this.age = getPersonalInformationUtilities().giveMeAnAge();
            this.gender = getPersonalInformationUtilities().giveMeAGender();
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
            this.middleName = getPersonalInformationUtilities().giveMeAMiddleName();
            return this;
        }

        public PersonalInformationBuilder withMiddleName(double probability) throws Exception {
            this.middleName = maybeAMiddleName(probability);
            return this;
        }

        private String maybeAMiddleName(double probabilityOfMiddleName) throws Exception {
            maximizeToOne(probabilityOfMiddleName);
            double probability = giveMeARandomNumberFrom1To(100);
            if ((probability/100) <=  (100/probabilityOfMiddleName)){
                return getPersonalInformationUtilities().giveMeAMiddleName();
            }else{
                return "";
            }
        }

        public PersonalInformationBuilder withDoubleSurname() throws Exception {
            this.surname = getPersonalInformationUtilities().giveMeASurname()
            + " " + getPersonalInformationUtilities().giveMeASurname();
            return this;
        }

        public PersonalInformationBuilder withAge(Integer age) throws Exception {
            if ((age > 0) && (age != null)) {
                this.age = age;
            }else this.age = 1;
            return this;
        }

        public PersonalInformationBuilder withAge(Ages age) throws WrongNumberException {
            int calculatedAge = 1;
            if (age == Ages.ADULT){
                calculatedAge = Utilities.giveMeARandomNumber(Constants.DEFAULT_AGE_ADULT_MIN,
                        Constants.DEFAULT_AGE_ADULT_MAX);
            }
            this.age = calculatedAge;
            return this;
        }

        public PersonalInformation build(){
            return new PersonalInformation(this);
        }

    }
}
