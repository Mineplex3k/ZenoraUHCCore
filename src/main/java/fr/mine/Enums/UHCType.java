package fr.mine.Enums;

public enum UHCType {

    MEETUP("meetup"),
    CLASSICO("Classico"),
    MODEDEJEUX("Mode De Jeux"),
    NONE("None");

    private final String name;

    UHCType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}
