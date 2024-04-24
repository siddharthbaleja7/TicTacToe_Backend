package com.siddharth.tictactoe.models;
import java.util.*;

import com.siddharth.tictactoe.Strategy.WinningStrategy;
import com.siddharth.tictactoe.enums.CellState;
import com.siddharth.tictactoe.enums.GameState;
import com.siddharth.tictactoe.Exception.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Board Board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> move;
    private GameState gameState;
    private WinningStrategy winningStrategies;

    public Game(int dimension, List<Player> players) {
        this.Board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.move = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;

    }
    public void printBoard(){
        this.Board.printBoard();




    }
    public void makeMove(Game game) throws InvalidMoveException{
        Player currentPlayer = this.players.get(nextPlayerMoveIndex);
        System.out.println("Player "+currentPlayer.getName()+"'s turn");
        Move move_var = currentPlayer.makeMove(Board);

        //game will validate the move
        if(!validateMove(move_var)){
            throw new InvalidMoveException("Invalid Move by"+ currentPlayer.getName());



        }
        int row = move_var.getCell().getRow();
        int col = move_var.getCell().getCol();
        Cell cellToChange = Board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        this.move.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
        // mod taken because we want to keep the index within the range of the players

        //chech if current move is the winning move
        if(WinningStrategy.checkWinner(Board, finalMove)){
            this.gameState = GameState.ENDED;
            this.winner = currentPlayer;
        }
    }
    public boolean validateMove(Move move){
        //check if the cell is empty
        //check if the cell is within the board
        //check if the move is made by the correct player

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row < 0 || row >= this.Board.getSize() || col < 0 || col >= this.Board.getSize()){
            return false;
        }

        return Board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);

    }



}