
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class ColorPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piece extends JPanel
{    
    private JPanel redPiece = new JPanel();
    private JLabel redPieceIcon = new JLabel();
    
    private JPanel yellowPiece = new JPanel();
    private JLabel yellowPieceIcon = new JLabel();
    
    private JPanel noPiece = new JPanel();
    private JLabel noPieceIcon = new JLabel();
    
    private CardLayout cards = new CardLayout();
    
    private int c;

    public Piece(int color)
    {
       c = color;
       setOpaque(false);
       setLayout(cards);
       
       redPiece.setOpaque(false);
       redPiece.add(redPieceIcon);
       redPieceIcon.setIcon(new ImageIcon("RedPiece.png"));
       
       yellowPiece.setOpaque(false);
       yellowPiece.add(yellowPieceIcon);
       yellowPieceIcon.setIcon(new ImageIcon("YellowPiece.png"));
       
       noPiece.setOpaque(false);
       noPiece.add(noPieceIcon);
       noPieceIcon.setIcon(new ImageIcon("NoPiece.png"));
       
       this.add(redPiece, "Red");
       this.add(yellowPiece, "Yellow");
       this.add(noPiece, "None");
        
       updatePiece();
    }
    
    public int getColor() {
        return c;
    }
   
    public void setColor(int c) {
        this.c = c;
        updatePiece();
    }

    
    public void updatePiece()
    {
       if(c == 1)
       {
           cards.show(this, "Red");
       }
       else if (c == 2)
       {
           cards.show(this, "Yellow");
       }
       else
       {
           cards.show(this, "None");
       }
    }
}