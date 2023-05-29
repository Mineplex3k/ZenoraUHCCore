package fr.mine.enums;
public enum GameState {

    WAITING("En attente"),
    STARTING("Lancement"),
    GAME("En jeu"),
    FINISH("Fini"),
    ENDING("Fermeture");

    private final String name;

    GameState(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
