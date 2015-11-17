package net.sinoriel.testsphere.repository;

/**
 * Created by armandosanchezmedina on 17/11/2015.
 */
public class Country {
    private String Name;
    private String TwoCharName;
    private String ThreeCharName;
    private String PhonePrefix;

    public Country() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTwoCharName() {
        return TwoCharName;
    }

    public void setTwoCharName(String twoCharName) {
        TwoCharName = twoCharName;
    }

    public String getThreeCharName() {
        return ThreeCharName;
    }

    public void setThreeCharName(String threeCharName) {
        ThreeCharName = threeCharName;
    }

    public String getPhonePrefix() {
        return PhonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        PhonePrefix = phonePrefix;
    }
}
