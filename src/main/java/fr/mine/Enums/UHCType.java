package fr.mine.Enums;

public enum UHCType {

    MEETUP("meetup"),
    CLASSICO("classique"),
    MODEDEJEUX("mode de jeux");

    private final String name;

    UHCType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}
