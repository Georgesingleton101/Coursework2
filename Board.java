import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 

public class Board extends JFrame
{
    ArrayList<Square> Squares = new ArrayList<Square>(); 
    static GraphicsConfiguration Board;
    String FrogType;
    Square Square4;

    public Board()
    {
        
    }
    public void FrogPostions(int a,int b, int c,int d, int e,int f)
        {
            int CurrentFrogPostion;
            int[] FrogsPositions = {a,b,c,d,e,f};
            CurrentFrogPostion = FrogsPositions[5];
             Square4 = Squares.get(CurrentFrogPostion);
            Square4.ChangeType("RedFrog");
            for(int i = 0; i < 5; i++)
            {
                CurrentFrogPostion = FrogsPositions[i];
                Square4 = Squares.get(CurrentFrogPostion);
                Square4.ChangeType("GreenFrog");
            }
            
        }
    public void Show()
    {
        
        int width = 140;
        int length = 120;
        int XTR = 0;
        int YTR = 0;
        int currentXTR = 0;
        int currentYTR = 0;
        int i = 0;
        int j = 0;
        String CurentImage;
        JButton[] buttons = new JButton[25];
        Icon Water =new ImageIcon("water.png");
        Icon LilyPad =new ImageIcon("LilyPad.png");
        Icon GreenFrog = new ImageIcon("GreenFrog.png");
        Icon RedFrog = new ImageIcon("RedFrog.png");
        JFrame frame = new JFrame(Board);	
        frame.setSize(700, 600);
		frame.setLayout(null); 
        
        
        for(j = 0; j < 5; j++)
        {
           
            for(int k = 0; k < 5; k++)
            {
                Square Square3 = new Square(currentXTR,currentYTR,width,length,"Water");
                Squares.add(Square3);
                currentXTR = currentXTR + 140;
                
            }
            currentXTR = 0;
            currentYTR =   currentYTR + 120;
        }
        // for loop ???
        for (i = 0; i < 25; i++) 
        {
            
            
            Square4 = Squares.get(i);
            XTR = Square4.GetXTR();
            YTR = Square4.GetYTR();
            frame.setSize(700, 600);
		    frame.setLayout(null); 
            buttons[i] = new JButton();
            buttons[i].setBounds(XTR,YTR,width,length);
            buttons[i].setIcon(Water);
            frame.add(buttons[i]);
            frame.setVisible(true);
        }    
        
        i = 0;
        while(i<25)
        {
            buttons[i].setIcon(LilyPad);
            Square4 = Squares.get(i);
            Square4.ChangeType("LilyPad");
            i = i + 2;
        }
    
       
        FrogPostions(6,8,12,20,24,22);
       
        for(i = 0; i < 25; i++)
        {
            Square4 = Squares.get(i);
            FrogType = Square4.GetType();
            if (FrogType == "RedFrog")
            {
                buttons[i].setIcon(RedFrog);
            }
            else if(FrogType == "GreenFrog")
            {
                buttons[i].setIcon(GreenFrog);
            }
            
            
        }

    }
   
}