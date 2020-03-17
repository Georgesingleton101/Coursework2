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
    Square Square5;
    int i = 0;
    int j = 0;
    int d;
    int h;
    boolean FrogSelected;
    boolean LilyPadSelected;
    int NewLily;
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
        String CurentImage;
        JButton[] buttons = new JButton[25];
        Icon Water =new ImageIcon("water.png");
        Icon LilyPad =new ImageIcon("LilyPad.png");
        Icon GreenFrog = new ImageIcon("GreenFrog.png");
        Icon RedFrog = new ImageIcon("RedFrog.png");
        Icon RedFrog2 = new ImageIcon("RedFrog2.png");
        Icon GreenFrog2 = new ImageIcon("GreenFrog2.png");
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
       
        
        i=0;
        for(int p=0; p < 25; p++)
        {
            int k = p;
            Square4 = Squares.get(k);
            FrogType = Square4.GetType();
            if (FrogType == "GreenFrog")
            {
                buttons[k].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        FrogSelected = true;
                        buttons[k].setIcon(GreenFrog2);
                        System.out.println(k);
                        NewLily = k;
                    }
                });
            }
            else if(FrogType == "RedFrog")
            {
                buttons[k].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        buttons[k].setIcon(RedFrog2);
                        FrogSelected = true;
                        NewLily = k;
                        System.out.println(k);
                    }
                });
            }
            
            if(FrogType == "LilyPad")
            {
                buttons[k].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        System.out.println(FrogSelected);
                        if (FrogSelected == true)
                        {
                            Square4 = Squares.get(k);
                            Square4.ChangeType("GreenFrog");
                            Square4 = Squares.get(NewLily);
                            Square4.ChangeType("LilyPad");
                            FrogType = Square4.GetType();
                            for (i=0;i<25;i++)
                            {
                                Square4 = Squares.get(i);
                                FrogType = Square4.GetType();
                                if (FrogType == "GreenFrog")
                                {
                                    buttons[i].setIcon(GreenFrog);
                                }
                                else if (FrogType == "LilyPad")
                                {
                                    buttons[i].setIcon(LilyPad);
                                }
                            }
                        }
                        FrogSelected = false;

                    }
                });
            }
            
        }
        
    }

   
}