import javax.swing.*;
import java.awt.*;
public class Board extends JFrame
{
    public static Square[][] board = new Square[6][7];
    int lastrow;
    int lastcol;
    public Board()
    {
        setLayout(new GridLayout(6,7));
        for(int r = 0; r < 6; r++)
        {
            for(int c = 0; c < 7; c++)
            {
                board[r][c]= new Square(r, c);
            }
        }

        for(Square[] row : board) {
            for(Square col : row) {
                getContentPane().add(col);
            }
        }
    }

    private boolean isMoveValid(int col)
    {
        return board[0][col].getColor() == 0;
    }

    public boolean dropPiece(int turn, int col)
    {
        int temp = 3;
        int i = 6;
        if(isMoveValid(col))
        {
            while(temp != 0)
            {
                i--;
                temp = board[i][col].getColor();
            }
            board[i][col].setColor(turn);
            gameWinner(turn,i,col);
            return true;
        }
        return false;
    }
    
    public void gameWinner(int turn, int row, int  col)
    {
        int hor = 1;
        int vert = 1;
        int slash = 1;
        int backslash = 1;
        boolean valid;
        int i;
        
        //hor checker
        i = 1; 
        valid = true;
        while(valid && col + i <= 6 )
        {
            if(board[row][col + i].getColor() == turn)
            {
                hor++;
                i++;
            }
            else
            {
                valid = false;
            }
        }
        i = -1;
        valid = true;
        while(valid && col + i >= 0)
        {
            if(board[row][col + i].getColor() == turn)
            {
                hor++;
                i--;
            }
            else
            {
                valid = false;
            }
        }
        
        //vert checker
        i = 1; 
        valid = true;
        while(valid && row + i <= 5 )
        {
            if(board[row + i][col].getColor() == turn)
            {
                vert++;
                i++;
            }
            else
            {
                valid = false;
            }
        }
        i = -1;
        valid = true;
        while(valid && row + i >= 0)
        {
            if(board[row + i][col].getColor() == turn)
            {
                vert++;
                i--;
            }
            else
            {
                valid = false;
            }
        }
        
        //slash checker (/)
        i = 1; 
        valid = true;
        while(valid &&(row + i <= 5 && col - i >= 0))
        {
            if(board[row + i][col - i].getColor() == turn)
            {
                slash++;
                i++;
            }
            else
            {
                valid = false;
            }
        }
        i = -1;
        valid = true;
        while(valid &&(row + i >= 0 && col - i <= 6))
        {
            if(board[row + i][col - i].getColor() == turn)
            {
                slash++;
                i--;
            }
            else
            {
                valid = false;
            }
        }
        
        //backslash checker (\)
        i = 1; 
        valid = true;
        while(valid &&(row + i <= 5 && col + i <= 6))
        {
            if(board[row + i][col + i].getColor() == turn)
            {
                backslash++;
                i++;
            }
            else
            {
                valid = false;
            }
        }
        i = -1;
        valid = true;
        while(valid &&(row + i >= 0 && col + i >= 0))
        {
            if(board[row + i][col + i].getColor() == turn)
            {
                backslash++;
                i--;
            }
            else
            {
                valid = false;
            }
        }
        if((backslash >=4)||(slash >=4)||(vert >=4)||(hor >= 4))
        {
            Main.gameWon = turn;
        }
    }
}