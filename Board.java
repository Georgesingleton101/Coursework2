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
    Square CurrentSquare;
    Square CurrentSquare2;
    int i = 0;
    int j = 0;
    boolean FrogSelected;
    int GF;
    boolean GreenFrogSelected;
    boolean RedFrogSelected;
    boolean CheckStatus;
    JButton[] buttons = new JButton[25];
    int Level;
    Icon LilyPad =new ImageIcon("LilyPad.png");
    int[] Levels = {26};
    int width = 140;
    int length = 120;
    int XTR = 0;
    int YTR = 0;
    int currentXTR = 0;
    int currentYTR = 0;
    Icon Water =new ImageIcon("water.png");
    Icon GreenFrog = new ImageIcon("GreenFrog.png");
    Icon RedFrog = new ImageIcon("RedFrog.png");
    Icon RedFrog2 = new ImageIcon("RedFrog2.png");
    Icon GreenFrog2 = new ImageIcon("GreenFrog2.png");
    public Board(int lvl)
    {
        Level = lvl;
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
        JFrame frame = new JFrame(Board);	
        frame.setSize(700, 600);
		frame.setLayout(null); 
        
     

        for (i = 0; i < 25; i++) 
        {
            CurrentSquare = Squares.get(i);
            XTR = CurrentSquare.GetXTR();
            YTR = CurrentSquare.GetYTR();
            frame.setSize(700, 600);
		    frame.setLayout(null); 
            buttons[i] = new JButton();
            buttons[i].setBounds(XTR,YTR,width,length);
            buttons[i].setIcon(Water);
            frame.add(buttons[i]);
            frame.setVisible(true);
        }    
       
    }

    public boolean GameWon()
    {
        for(i = 0; i < 25; i ++)
        {
            int j = i;
            CurrentSquare = Squares.get(j);
            FrogType = CurrentSquare.GetType();
            if (FrogType == "GreenFrog")
            {
                return false;
            }
        }
        return true;
    }
    
    public void FrogPostions(int NumFrogs, int a,int b, int c,int d, int e,int f,int g)
    {
            int NumberOfFrogs = NumFrogs;
            int CurrentFrogPostion;
            int[] FrogsPositions = {a,b,c,d,e,f,g};
            CurrentFrogPostion = FrogsPositions[0];
             CurrentSquare = Squares.get(CurrentFrogPostion);
            CurrentSquare.ChangeType("RedFrog");
            for(int i = 1; i < NumberOfFrogs + 1; i++)
            {
                CurrentFrogPostion = FrogsPositions[i];
                if (CurrentFrogPostion == 25)
                {}
                else 
                {
                   CurrentSquare = Squares.get(CurrentFrogPostion);
                CurrentSquare.ChangeType("GreenFrog"); 
                }
            }
            
    }
    public boolean FrogPostionsChecker(int CurrPos, int ArrPos, int x, int y)
    {
        int CurrentPosition = CurrPos;
        int ArrangedPostion = ArrPos;
        CurrentSquare = Squares.get(CurrentPosition+x);
            FrogType = CurrentSquare.GetType();
            if ((FrogType == "GreenFrog") && (ArrangedPostion == CurrentPosition + y))
            {
                x = CurrentPosition + x;
                buttons[x].setIcon(LilyPad);
                CurrentSquare = Squares.get(x);
                CurrentSquare.ChangeType("LilyPad");
                return true;
            }
        return false;
    }
    public boolean LegalMove(int CurrPos, int ArrPos)
    {
        int CurrentPosition = CurrPos;
        int ArrangedPostion = ArrPos;
        if (((CurrentPosition == 0) || (CurrentPosition == 10)|| (CurrentPosition == 20)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 2,4);
        }  
        else if (((CurrentPosition == 4) || (CurrentPosition == 14)|| (CurrentPosition == 24)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -2,-4);
        }
        if (((CurrentPosition == 0) || (CurrentPosition == 2)|| (CurrentPosition == 4)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 10,20);
        }
        else if (((CurrentPosition == 20) || (CurrentPosition == 22)|| (CurrentPosition == 24)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -10,-20);
        }
        if ((CurrentPosition > -1) && (CurrentPosition < 11 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 6,12);
        }
        if ((CurrentPosition > 11 ) && (CurrentPosition < 25 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -6,-12);
        }
         if ((CurrentPosition > 1 ) && (CurrentPosition < 5 ) || (CurrentPosition > 6 ) && (CurrentPosition < 9 ) || (CurrentPosition > 11 ) && (CurrentPosition < 15 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 4,8);
        }
         if ((CurrentPosition > 9 ) && (CurrentPosition < 13 ) || (CurrentPosition > 14 ) && (CurrentPosition < 18 ) || (CurrentPosition > 19 ) && (CurrentPosition < 23 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -4,-8);
        }
        if (CheckStatus == true)
            {
                return true;
            }
        return false;
    }

    public void Show()
    {
        i = 0;
        while(i<25)
        {
            buttons[i].setIcon(LilyPad);
            CurrentSquare = Squares.get(i);
            CurrentSquare.ChangeType("LilyPad");
            i = i + 2;
        }

       if (Level == 1)
       {
           FrogPostions(2,0,6,25,25,25,6,0);
       }
        
        for(i = 0; i < 25; i++)
        {
            CurrentSquare = Squares.get(i);
            FrogType = CurrentSquare.GetType();
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
        for(i=0; i < 25; i++)
        {
            int k = i;
            buttons[k].addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    CurrentSquare = Squares.get(k);
                    FrogType = CurrentSquare.GetType();
                    
                    if(FrogType == "GreenFrog")
                    {
                        RedFrogSelected = false;
                        GreenFrogSelected = true;
                        GF = k;
                        buttons[k].setIcon(GreenFrog2);
                    }
                    else if(FrogType == "RedFrog")
                    {
                        GreenFrogSelected = false;
                        RedFrogSelected = true;
                        GF = k;
                        buttons[k].setIcon(RedFrog2);
                    }
                    else if ((FrogType == "LilyPad"))

                    {
                        if (GreenFrogSelected == true)
                       
                        {
                            GreenFrogSelected = false;
                            int LP = k;
                            boolean BooleanIsMovLeg = LegalMove(GF,LP);
                            if (BooleanIsMovLeg == true)
                            {
                                CurrentSquare = Squares.get(GF);
                                
                                CurrentSquare2 = Squares.get(LP);
                                CurrentSquare.MoveTo(CurrentSquare2);
                                buttons[LP].setIcon(GreenFrog);
                                buttons[GF].setIcon(LilyPad);
                                }

                        }
                        else if (RedFrogSelected == true)
                        {
                            RedFrogSelected = false;
                            int LP = k;
                            boolean BooleanIsMovLeg = LegalMove(GF,LP);
                            if (BooleanIsMovLeg == true)
                            {
                                CurrentSquare = Squares.get(GF);
                                CurrentSquare2 = Squares.get(LP);
                                CurrentSquare.MoveTo(CurrentSquare2);
                                buttons[LP].setIcon(RedFrog);
                                buttons[GF].setIcon(LilyPad);
                            }
                        }
                    }
                    else if (FrogType == "Water")
                    {
                        RedFrogSelected = false;
                        GreenFrogSelected = false;
                    }
                boolean Won = GameWon();
                if (Won == true)
                {
                    System.out.println("Congratulations you have won!!");
                }  
                }
            });
        }   
    }
}