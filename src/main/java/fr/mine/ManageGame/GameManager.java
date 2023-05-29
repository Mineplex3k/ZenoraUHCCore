package fr.mine.ManageGame;


import fr.mine.enums.GameState;

public class GameManager {

    GameState gameState;

    public GameManager(){
        gameState = GameState.FINISH;
    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


}
