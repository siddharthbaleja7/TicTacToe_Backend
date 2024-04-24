package com.siddharth.tictactoe;

import com.siddharth.tictactoe.Controller.Gamecontroller;
import com.siddharth.tictactoe.Exception.InvalidMoveException;
import com.siddharth.tictactoe.enums.BotDifficultyLevel;
import com.siddharth.tictactoe.enums.GameState;
import com.siddharth.tictactoe.enums.PlayerType;
import com.siddharth.tictactoe.models.Bot;
import com.siddharth.tictactoe.models.Game;
import com.siddharth.tictactoe.models.Player;
import com.siddharth.tictactoe.models.Symbol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) throws InvalidMoveException {
        SpringApplication.run(TicTacToeApplication.class, args);
        Gamecontroller gameController = new Gamecontroller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimensions of the board");
        int dimensions = scanner.nextInt();
        List<Player> players = List.of(
                new Player("Player 1", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Player 2", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY )
        );
        Game game =  gameController.startGame(dimensions, players);
//        gameController.printBoard(game);

        // Create the game

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.printBoard(game);

        }
        if(!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("The game is a draw");

        }
        else{
            System.out.println("The winner is "+gameController.checkWinner(game).getName());
        }
    }
}