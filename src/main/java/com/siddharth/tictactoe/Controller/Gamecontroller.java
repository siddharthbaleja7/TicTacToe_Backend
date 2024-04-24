package com.siddharth.tictactoe.Controller;

import com.siddharth.tictactoe.enums.GameState;
import com.siddharth.tictactoe.models.Game;
import com.siddharth.tictactoe.models.Player;
import com.siddharth.tictactoe.Exception.InvalidMoveException;
import java.util.List;

public class Gamecontroller {
    public Game startGame(int dimensions, List<Player> players) {
        ///validate if the two players have same symbols then throw exception

        return new Game(dimensions, players);

    }
    public void makeMove(Game game) throws InvalidMoveException{
        game.makeMove(game);
    }
    public GameState checkState(Game game){
        return game.getGameState();

    }
    public Player checkWinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game){
        game.printBoard();

    }

}