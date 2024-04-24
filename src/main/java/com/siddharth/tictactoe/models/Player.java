package com.siddharth.tictactoe.models;

import com.siddharth.tictactoe.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;

    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public Move makeMove(Board board){
        //ask the player to make a move
        System.out.println("Enter the row and column number to make a move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();


        return new Move(new Cell(row, col), this);


    }

}