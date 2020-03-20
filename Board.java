import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 
/**
*This class implements a form and defines the methods to create the hoppers game.
*@author George Singleton
*@version 2.0
*/
public class Board extends JFrame
{
    private ArrayList<Square> Squares = new ArrayList<Square>(); 
    static GraphicsConfiguration Board;
    private String FrogType;
    private Square CurrentSquare;
    private Square CurrentSquare2;
    private int i = 0;
    private int j = 0;
    private boolean FrogSelected;
    private int GF;
    private boolean GreenFrogSelected;
    private boolean RedFrogSelected;
    private JButton[] buttons = new JButton[25];
    private int Level;
    private Icon LilyPad =new ImageIcon("LilyPad.png");
    private int[] Levels = {206,24};
    private int width = 140;
    private int length = 120;
    private int XTR = 0;
    private int YTR = 0;
    private int currentXTR = 0;
    private int currentYTR = 0;
    private Icon Water =new ImageIcon("water.png");
    private Icon GreenFrog = new ImageIcon("GreenFrog.png");
    private Icon RedFrog = new ImageIcon("RedFrog.png");
    private Icon RedFrog2 = new ImageIcon("RedFrog2.png");
   private  Icon GreenFrog2 = new ImageIcon("GreenFrog2.png");
    /**
    *This constructor 
    *@param lvl the level of the game to be played 
    */
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
    
    /**
	* When called this method checks to see if the game has been won
	* @return boolean state if game has been won or not
	*/
    public boolean GameWon()
    {
        for(i = 0; i < 25; i ++)
        {
            j = i;
            CurrentSquare = Squares.get(j);
            FrogType = CurrentSquare.GetType();
            if (FrogType == "GreenFrog")
            {
                return false;
            }
        }
        return true;
    }

    /**
	*This method changes the type of the squares to the appropiate type
	* @param NumFrogs number of frogs to be placed in the game
    * @param RedFrogPosition position for the red frog to be placed
    * @param GreenFrog1Pos position for the first green frog to be placed
    * @param GreenFrog2Pos position for the second green frog to be placed
    * @param GreenFrog3Pos position for the third green frog to be placed
    * @param GreenFrog4Pos position for the fourth green frog to be placed
    * @param GreenFrog5Pos position for the fifth green frog to be placed
    * @param GreenFrog6Pos position for the sixth green frog to be placed
	*/
    public void FrogPostions(int NumFrogs, int RedFrogPos,int GreenFrog1Pos, int GreenFrog2Pos,int GreenFrog3Pos, int GreenFrog4Pos,int GreenFrog5Pos,int GreenFrog6Pos)
    {
        int NumberOfFrogs = NumFrogs;
        int CurrentFrogsPositiontion;
        int[] FrogsPositions = {RedFrogPos,GreenFrog1Pos,GreenFrog2Pos,GreenFrog3Pos,GreenFrog4Pos,GreenFrog5Pos,GreenFrog6Pos};
        CurrentFrogsPositiontion = FrogsPositions[0];
        CurrentSquare = Squares.get(CurrentFrogsPositiontion);
        CurrentSquare.ChangeType("RedFrog");
        for(int i = 1; i < NumberOfFrogs + 1; i++)
        {
            CurrentFrogsPositiontion = FrogsPositions[i];
            if (CurrentFrogsPositiontion == 25)
            {}
            else 
            {
                CurrentSquare = Squares.get(CurrentFrogsPositiontion);
                CurrentSquare.ChangeType("GreenFrog"); 
            }
        }
    }

    /**
	* This method is part of the level system which decodes the level array to find the appropiate level position
	* @param lvl the level the user wishes to play
	*/
    public void GetFrogsPostions(int lvl)
    {
        int[] FrogsPositionStore = {25,25,25,25,25,25,25};
        Level = lvl;
        int IntLevelData = Levels[Level-1];
        //System.out.println(IntLevelData);
        String StringLevelData = String.valueOf(IntLevelData);
        String StringNumberOfFrogs = StringLevelData.substring(0,1);
        int IntNumberOfFrogs = Integer.valueOf(StringNumberOfFrogs);
        System.out.println(IntNumberOfFrogs);
        for (i=1; i < IntNumberOfFrogs+1;i++)
        {
            String StringTest = StringLevelData.substring(i,i+1);
            int IntTest = Integer.valueOf(StringTest);
            //IntTest = IntTest -1;
            //System.out.println(Test);
            if (IntTest == -100)
            {
                //StringTest = StringLevelData.substring(i+1,i+3);
                //IntTest = Integer.valueOf(StringTest);
                //System.out.println(IntTest);
            }
            else 
            {
                FrogsPositionStore[i-1] = IntTest;
                System.out.println(IntTest);
            }
        }
        FrogPostions(IntNumberOfFrogs,FrogsPositionStore[0] ,FrogsPositionStore[1],FrogsPositionStore[2] ,FrogsPositionStore[3],FrogsPositionStore[4],FrogsPositionStore[5],FrogsPositionStore[6]);
    }

    /**
	* This method is checks to see if the preposed move positions is legal or not and in combination with the legal move function can return if the move is legal or not
	* @param CurrPos the current position of the frog before the move is taken
    * @param ArrPos the preposed position of the frog after the move is taken
    * @param JumpedOverSquare the number added to the currentpositon to find the square that is being jumped over
    * @param ArrPos the number added to the currentposition to find and check the arranged position is correct before a move is preformed
	*/
    public boolean FrogPostionsChecker(int CurrPos, int ArrPos, int JumpedOverSquare, int JumpedToSquare)
    {
        int CurrentPosition = CurrPos;
        int ArrangedPostion = ArrPos;
        CurrentSquare = Squares.get(CurrentPosition+JumpedOverSquare);
            FrogType = CurrentSquare.GetType();
            if ((FrogType == "GreenFrog") && (ArrangedPostion == CurrentPosition + JumpedToSquare))
            {
                //System.out.println(JumpedOverSquare);
                JumpedOverSquare = CurrentPosition + JumpedOverSquare;
                buttons[JumpedOverSquare].setIcon(LilyPad);
                CurrentSquare = Squares.get(JumpedOverSquare);
                CurrentSquare.ChangeType("LilyPad");
                //System.out.println(JumpedOverSquare);
                return true;
            }
        return false;
    }
    /**
	* This method is checks the current position and then defines the appropiate possible moves that can be taken, in combination with the FrogPositionChecker function it will decide if a move is legal or not
	* @param CurrPos the current position of the frog before the move is taken
    * @param ArrPos the preposed position of the frog after the move is taken
    */
    public boolean LegalMove(int CurrPos, int ArrPos)
    {
        boolean CheckStatus = false;
        int CurrentPosition = CurrPos;
        int ArrangedPostion = ArrPos;
        if (((CurrentPosition == 0) || (CurrentPosition == 10)|| (CurrentPosition == 20)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 2,4);
            if (CheckStatus == true)
            {
                return true;
            }
        }  
        else if (((CurrentPosition == 4) || (CurrentPosition == 14)|| (CurrentPosition == 24)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -2,-4);
            if (CheckStatus == true)
            {
                return true;
            }
        }
        if (((CurrentPosition == 0) || (CurrentPosition == 2)|| (CurrentPosition == 4)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 10,20);
            if (CheckStatus == true)
            {
                return true;
            }
        }
        else if (((CurrentPosition == 20) || (CurrentPosition == 22)|| (CurrentPosition == 24)))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -10,-20);
            if (CheckStatus == true)
            {
                return true;
            }
        }
        if ((CurrentPosition > -1) && (CurrentPosition < 11 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 6,12);
            if (CheckStatus == true)
            {
                return true;
            }
        }
        if ((CurrentPosition > 11 ) && (CurrentPosition < 25 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -6,-12);
            if (CheckStatus == true)
            {
                return true;
            }
        }
         if ((CurrentPosition > 1 ) && (CurrentPosition < 5 ) || (CurrentPosition > 6 ) && (CurrentPosition < 9 ) || (CurrentPosition > 11 ) && (CurrentPosition < 15 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, 4,8);
            if (CheckStatus == true)
            {
                return true;
            }
        }
         if ((CurrentPosition > 9 ) && (CurrentPosition < 13 ) || (CurrentPosition > 14 ) && (CurrentPosition < 18 ) || (CurrentPosition > 19 ) && (CurrentPosition < 23 ))
        {
            CheckStatus = FrogPostionsChecker(CurrentPosition, ArrangedPostion, -4,-8);
            if (CheckStatus == true)
            {
                return true;
            }
        }
        if (CheckStatus == true)
        {
                return true;
        }
        return false;
    }

    /**
	* This method resets the buttons to the default type contained in it's square class
    */
    public void ResetDefaultSquares()
    {
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
    }

    /**
	* This method sets up the default position of the lilypads 
    */
    public void SetLilyPads()
    {
         i = 0;
        while(i<25)
        {
            buttons[i].setIcon(LilyPad);
            CurrentSquare = Squares.get(i);
            CurrentSquare.ChangeType("LilyPad");
            i = i + 2;
        }
    }
    /**
	* This method sets up the click action in which it will check if a frog then a lilypad is pressed and if so will move the frog acordingly.It will also print out a message if the game has been won.
    */
    public void SetOnClick()
    {
        //FrogPostions(4,2,6,8,16,18,25,25);
        ResetDefaultSquares();
        for(i=0; i < 25; i++)
        {
            int k = i;
            buttons[k].addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    ResetDefaultSquares();
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