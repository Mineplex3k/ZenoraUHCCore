package fr.mine.ManageGame;


import fr.mine.Enums.GameState;
import fr.mine.Enums.UHCType;

public class GameManager {
    UHCType uhcType;
    UHCType uhcConfig;
    GameState gameState;
    int playersize;
    int roledistritime;
    String prefix;

    int min;
    int sec;
    int heure;
    int invinci;


    public GameManager(){
        gameState = GameState.WAITING;
        uhcType = UHCType.NONE;
        uhcConfig = UHCType.CLASSICO; //Type de Meetup : Classico ou a Mode de Jeux
        prefix = "§b[Zenora] §7|§f";
        playersize = 24;
        roledistritime = 20;  //uniquement en minute
        sec = 0;
        min = 0;
        heure = 0;   //TODO : heure, min, sec admin uniquement dans le GUI host
        invinci = 5; //minute
    }

    //Game Manager Etat de la partie
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    //Game Taille des Joueurs
    public Integer getPlayersize() {
        return playersize;
    }
    public void setPlayersize(Integer playersize) {
        this.playersize = playersize;
    }

    public int getRoledistritime() {
        return roledistritime;
    }

    public void setRoledistritime(int roledistritime) {
        this.roledistritime = roledistritime;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec() {
        this.sec = sec;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getInvinci() {
        return invinci;
    }

    public void setInvinci(int invinci) {
        this.invinci = invinci;
    }

    public UHCType getUhcType() {
        return uhcType;
    }

    public void setUhcType(UHCType uhcType) {
        this.uhcType = uhcType;
    }

    public String getPrefix() {
        return prefix;
    }

    public UHCType getUhcConfig() {
        return uhcConfig;
    }

    public void setUhcConfig(UHCType uhcConfig) {
        this.uhcConfig = uhcConfig;
    }


}
