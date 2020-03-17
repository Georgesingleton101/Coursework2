
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 



public class Square extends JFrame 
{
    private int XTopRight;
    private int YTopRight;
    private int Width;
    private int Length;
    private String Type;
    public Square(int X, int Y,int W, int L,String T)
    {
        XTopRight = X;
        YTopRight = Y;
        Width = W;
        Length = L;  
        Type = T;   
    } 
    public int GetXTR()
    {
        return XTopRight;
    }
    public int GetYTR()
    {
        return YTopRight;
    }
    public int GetWidth()
    {
        return Width;
    }
    public int GetLength()
    {
        return Length;
    }
    public String GetType()
    {
        return Type;
    }
    public void ChangeType(String NewType)
    {
        Type = NewType;
    }

    
    public void MoveTo(Square S1)
    {
        
        S1.ChangeType("LilyPad");
    }
    

 }
