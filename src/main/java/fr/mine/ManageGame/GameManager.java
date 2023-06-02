package fr.mine.ManageGame;


import fr.mine.Enums.GameState;

public class GameManager {

    GameState gameState;
    int playersize;
    int roledistritime;

    int min;
    int sec;
    int heure;
    int invinci;


    public GameManager(){
        gameState = GameState.WAITING;
        playersize = 24;
        roledistritime = 20;  //uniquement en minute
        heure = 0;
        min = 0;
        heure = 0;   //TODO : heure, min, sec admin uniquement
        invinci = 5;

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

    public void setPlayersize(int playersize) {
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

    public void setSec(int sec) {
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

}
