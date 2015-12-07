package net.sinoriel.testsphere.classes;

import net.sinoriel.testsphere.exceptions.WrongNumberException;
import net.sinoriel.testsphere.repository.*;
import net.sinoriel.testsphere.utilities.PersonalInformationUtilities;
import net.sinoriel.testsphere.utilities.Utilities;

import static net.sinoriel.testsphere.utilities.PersonalInformationUtilities.*;
import static net.sinoriel.testsphere.utilities.Utilities.*;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class PersonalInformation {
    private String name;
    private String surname;
    private String middleName;
    private Integer age;
    private Genders gender;
    private Country nationality;
    private Country dualNationality;
    private String title;


    public PersonalInformation(PersonalInformationBuilder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.middleName = builder.middleName;
        this.age = builder.age;
        this.gender = builder.gender;
        this.nationality = builder.nationality;
        this.dualNationality = builder.dualNationality;
        this.title = builder.title;
    }

    protected PersonalInformation(PersonalInformation toClone){
        this.name = toClone.name;
        this.surname = toClone.surname;
        this.middleName = toClone.middleName;
        this.age = toClone.age;
        this.gender = toClone.gender;
        this.nationality = toClone.nationality;
        this.dualNationality = toClone.dualNationality;
        this.title = toClone.title;
    }

    @Override
    public PersonalInformation clone(){
        return new PersonalInformation(this);
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

    public String getNationalityDescription() { return nationality.getName(); }

    public String getNationalityWith2ISO() { return nationality.getTwoCharName(); }

    public String getNationalityWith3ISO() { return nationality.getThreeCharName(); }

    public String getNationalityPrefix() { return nationality.getPhonePrefix(); }

    public String getDualNationalityDescription() { return dualNationality.getName(); }

    public String getDualNationalityWith2ISO() { return dualNationality.getTwoCharName(); }

    public String getDualNationalityWith3ISO() { return dualNationality.getThreeCharName(); }

    public String getDualNationalityPrefix() { return dualNationality.getPhonePrefix(); }

    public String getTitle() { return title;}

    @Override
    public String toString(){
        StringBuilder personalInformation = new StringBuilder();
        addValue(personalInformation, "Title", title);
        addValue(personalInformation, "Name", name);
        addValue(personalInformation,"Surname",surname);
        if (middleName.length() > 0) {
            addValue(personalInformation,"MiddleName",middleName);
        }
        addValue(personalInformation,"Age",age.toString());
        addValue(personalInformation,"Gender",gender.toString());
        addValue(personalInformation, "Nationality", getNationalityDescription());
        if (getDualNationalityDescription().length()> 0 && dualNationality!=null) {
            addValue(personalInformation,"Dual Nationality",getDualNationalityDescription());
        }
        return personalInformation.toString();

    }

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
        private Country nationality;
        private Country dualNationality;
        private String title;

        public PersonalInformationBuilder() throws Exception {
            this.gender = getPersonalInformationUtilities().giveMeAGender();
            this.nationality = getPersonalInformationUtilities().giveMeANationality();
            this.dualNationality = maybeADualNationalityAndnot(this.nationality, Constants.DEFAULT_PROBABILITY_FOR_SECOND_NATIONALITY);
            this.name = getPersonalInformationUtilities().giveMeAName(this.gender);
            this.surname = getPersonalInformationUtilities().giveMeASurname();
            this.middleName = maybeAMiddleName(Constants.DEFAULT_PROBABILITY_FOR_MIDDLE_NAMES);
            this.age = getPersonalInformationUtilities().giveMeAnAge();
            this.title = getPersonalInformationUtilities().giveMeATitle(this.gender);
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

        public PersonalInformationBuilder withGender(Genders gender) throws Exception {
            this.gender = gender;
            this.name = getPersonalInformationUtilities().giveMeAName(this.gender);
            return this;
        }

        public PersonalInformationBuilder withNationalityISO2(String nationality){
            this.nationality = PersonalInformationUtilities.getCountryByISO2(nationality);
            return this;
        }

        public PersonalInformationBuilder withNationalityISO3(String nationality){
            this.nationality = PersonalInformationUtilities.getCountryByISO3(nationality);
            return this;
        }


        public PersonalInformationBuilder withDualNationalityISO2(String nationality){
            this.dualNationality = PersonalInformationUtilities.getCountryByISO2(nationality);
            return this;
        }

        public PersonalInformationBuilder withDualNationalityISO3(String nationality){
            this.dualNationality = PersonalInformationUtilities.getCountryByISO3(nationality);
            return this;
        }

        public PersonalInformation build() throws CloneNotSupportedException {
            PersonalInformation personalInformation = new PersonalInformation(this);
            DataRepository.currentPersonalInformation = personalInformation.clone();
            return personalInformation;
        }

        public PersonalInformationBuilder withDualNationality(Double probability) throws Exception {
            Country nationality = PersonalInformationUtilities.getCountryByISO2(DataRepository.currentPersonalInformation.getNationalityWith2ISO());
            this.dualNationality = maybeADualNationalityAndnot(nationality, probability);
            return this;
        }

        public PersonalInformationBuilder withTitle(String title){
            this.title = title;
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

        private Country maybeADualNationalityAndnot(Country nationality, double probabilityOfMiddleName) throws Exception {
            maximizeToOne(probabilityOfMiddleName);
            double probability = giveMeARandomNumberFrom1To(100);
            if ((probability/100) <=  (100/probabilityOfMiddleName)){
                return getPersonalInformationUtilities().giveMeANationalityAndNot(nationality);
            }else{
                return new Country();
            }
        }

    }
}
