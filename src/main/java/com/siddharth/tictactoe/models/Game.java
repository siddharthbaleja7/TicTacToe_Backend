package com.siddharth.tictactoe.models;
import java.util.*;

import com.siddharth.tictactoe.enums.GameState;

public class Game {
    private Board Board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> move;
   private GameState gameState;
}
