package com.rinndp.countriescycler;

public class CountryModel {
    public String countryName;
    public String countryDescription;
    public String countryFlag;
    public String countryCapital;


    public CountryModel(String petName, String petDescription, String countryFlag, String countryCapital) {
        this.countryName = petName;
        this.countryDescription = petDescription;
        this.countryFlag = countryFlag;
        this.countryCapital = countryCapital;
    }

    public String getPetName() {
        return countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getPetDescription() {
        return countryDescription;
    }

    public String getCountryCapital() {
        return countryCapital;
    }
}
