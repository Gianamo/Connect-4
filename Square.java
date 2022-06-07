import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends JPanel
{
    private Piece p;
    public static boolean pieceSelected = false;
    
    private int selectedColumn;
    private final int row;
    private final int col;
    public Square(int row, int col)
    {
        this.row = row;
        this.col = col;
        
        p = new Piece(0);
        setBackground(Color.blue);
        
        setLayout(new GridLayout(1,1));
        add(p);

        addMouseListener(new ClickListener());
    }

    public int getColor()
    {
        return p.getColor();
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public Piece getPiece() 
    {
        return p;
    }
    
    public void setColor(int c)
    {
        p.setColor(c);
    }

    private class ClickListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            Square selectedSquare = (Square) e.getSource();
            selectedColumn = selectedSquare.getCol();
            Main.selectedSquare = selectedSquare;
            
            Main.move(selectedColumn);
        }
        
    }
} 