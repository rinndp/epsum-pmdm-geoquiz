package com.rinndp.petsrecycler;

public class PetsModel {
    public String petName;
    public String petBreed;
    public String petDescription;

    public PetsModel (String petName, String petBreed, String petDescription) {
        this.petName = petName;
        this.petBreed = petBreed;
        this.petDescription = petDescription;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetDescription() {
        return petDescription;
    }
}
