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
    String FrogType2;
    Square Square4;
    Square Square5;
    int i = 0;
    int j = 0;
    int d;
    int h;
    boolean FrogSelected;
    boolean LilyPadSelected;
    int NewLily;
    int GF;
    boolean GreenFrogSelected;
    boolean RedFrogSelected;
    boolean CheckStatus;
    JButton[] buttons = new JButton[25];
    Icon LilyPad =new ImageIcon("LilyPad.png");
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
    public boolean FrogPostionsChecker(int CurrPos, int ArrPos, int x, int y)
    {
        int CurrentPosition = CurrPos;
        int ArrangedPostion = ArrPos;
        Square4 = Squares.get(CurrentPosition+x);
            FrogType = Square4.GetType();
            
            if ((FrogType == "GreenFrog") && (ArrangedPostion == CurrentPosition + y))
            {
                x = CurrentPosition + x;
                //System.out.println(x);
                buttons[x].setIcon(LilyPad);
                Square4 = Squares.get(x);
                Square4.ChangeType("LilyPad");
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
            //System.out.println(CheckStatus);
            if (CheckStatus == true)
            {
                //System.out.println("hello");
                return true;
            }
        }
           
        else if (((CurrentPosition == 4) || (CurrentPosition == 14)|| (CurrentPosition == 24)))
        {
            //System.out.println(CurrentPosition);
            //System.out.println(ArrangedPostion);
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -2,-4);
           //System.out.println(CheckStatus);
            if (CheckStatus == true)
            {
                //System.out.println("hello");
                return true;
            }
           
            
        }
        if (((CurrentPosition == 0) || (CurrentPosition == 2)|| (CurrentPosition == 4)))
        {
           CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 10,20);
           //System.out.println(CheckStatus);
            if (CheckStatus == true)
            {
                //System.out.println("hello");
                return true;
            }
        }
        else if (((CurrentPosition == 20) || (CurrentPosition == 22)|| (CurrentPosition == 24)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -10,-20);
           // System.out.println(CheckStatus);
            if (CheckStatus == true)
            {
               // System.out.println("hello");
                return true;
            }
        }
        if ((CurrentPosition > -1) && (CurrentPosition < 11 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 6,12);
            if (CheckStatus == true)
            {
               // System.out.println("hello");
                return true;
            }
        }
        if ((CurrentPosition > 11 ) && (CurrentPosition < 25 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -6,-12);
            if (CheckStatus == true)
            {
                //System.out.println("hello");
                return true;
            }
        }
         if ((CurrentPosition > 1 ) && (CurrentPosition < 5 ) || (CurrentPosition > 6 ) && (CurrentPosition < 9 ) || (CurrentPosition > 11 ) && (CurrentPosition < 15 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 4,8);
          if (CheckStatus == true)
            {
               // System.out.println("hello");
                return true;
            }
        }
         if ((CurrentPosition > 9 ) && (CurrentPosition < 13 ) || (CurrentPosition > 14 ) && (CurrentPosition < 18 ) || (CurrentPosition > 19 ) && (CurrentPosition < 23 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -4,-8);
           if (CheckStatus == true)
            {
               // System.out.println("hello");
                return true;
            }
        }
        
        return false;
       
    
        
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
        
        Icon Water =new ImageIcon("water.png");
        
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
    
       
        FrogPostions(2,10,14,16,24,22);
       
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
        for(i=0; i < 25; i++)
        {
            int k = i;
            buttons[k].addActionListener(new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) {
                 
                    Square4 = Squares.get(k);
                    FrogType = Square4.GetType();
                    //System.out.println(FrogType);
                    //Square4.ChangeType("GreenFrog");
                    if(FrogType == "GreenFrog")
                    {
                        //System.out.println("Hello");
                        RedFrogSelected = false;
                        GreenFrogSelected = true;
                        GF = k;
                        buttons[k].setIcon(GreenFrog2);
                    }
                    else if(FrogType == "RedFrog")
                    {
                        //System.out.println("Hello");
                        GreenFrogSelected = false;
                        RedFrogSelected = true;
                        GF = k;
                        buttons[k].setIcon(RedFrog2);
                    }
                   // System.out.println(FrogSelected);
                    //System.out.println(FrogType);
                    else if ((FrogType == "LilyPad"))

                    {
                        //System.out.println(GreenFrogSelected);
                        //System.out.println(RedFrogSelected);
                        if (GreenFrogSelected == true)
                       
                        {
                            //System.out.println("Magic");
                           
                            GreenFrogSelected = false;
                            int LP = k;
                            //System.out.println(GF);
                            //System.out.println(LP);
                            boolean BooleanIsMovLeg = LegalMove(GF,LP);
                            //System.out.println(BooleanIsMovLeg);
                            if (BooleanIsMovLeg == true)
                            {
                            Square4 = Squares.get(GF);
                            
                            Square5 = Squares.get(LP);
                            Square4.MoveTo(Square5);
                            buttons[LP].setIcon(GreenFrog);
                            buttons[GF].setIcon(LilyPad);
                            }

                        }
                        else if (RedFrogSelected == true)
                        {
                             //System.out.println("Magic");
                            RedFrogSelected = false;
                            int LP = k;
                            //System.out.println(GF);
                            //System.out.println(LP);
                            boolean BooleanIsMovLeg = LegalMove(GF,LP);
                            if (BooleanIsMovLeg == true)
                            {
                            Square4 = Squares.get(GF);
                            Square5 = Squares.get(LP);
                            Square4.MoveTo(Square5);
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
                  
                  
                    
                    
                }
            });

            
        }



            
            
    }

   
}