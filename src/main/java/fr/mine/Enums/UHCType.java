package fr.mine.Enums;

public enum UHCType {

    MEETUP("meetup"),
    CLASSICO("Classico"),
    MODEDEJEUX("mode de jeux"),
    NONE("none");

    private final String name;

    UHCType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}
