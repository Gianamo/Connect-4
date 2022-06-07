import javax.swing.*; //for making windows (Jframe, JPanel)
import java.awt.*; //for color
import java.util.*;
import java.awt.event.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static int turn = 1;
    public static int gameWon = 0;
    
    public static Square selectedSquare = null;
    static Board game = new Board();

    public static void main(String[] args)
    {
        game.setSize(700,700);
        game.setResizable(false);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.setVisible(true);
        printCurrentTurn();
    }

    public static void printCurrentTurn()
    {
        if(turn == 1)
        {
            System.out.println("Red's's Turn");
        }
        else if(turn == 2)
        {
            System.out.println("Yellow's Turn");
        }
    }

    /**
     * Precondition: startSquare and endSquare must not be null
     */
    public static void move(int column)
    {
        if(gameWon != 0)
        {
            return;
        }
        
        boolean valid = game.dropPiece(turn, column);
        if(!valid)
        {
            return;
        }
        
        if(turn == 1)
        {
            turn = 2;
        }
        else
        {
            turn = 1;
        }
        
        gameWin(gameWon);
        
        printCurrentTurn();
    }
    
    public static void gameWin(int gameStatus) 
    {
        if (gameStatus == 1)
        {
            System.out.println("Red Wins");
        }
        else if (gameStatus == 2)
        {
            System.out.println("Yellow Wins");
        }
        else
        {
            System.out.println("You broke it");
        }
    }
}