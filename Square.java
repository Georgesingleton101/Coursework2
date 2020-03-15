
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
    private double XTopRight;
    private double YTopRight;
    private double Width;
    private double Length;
    public Square(double X, double Y,double W, double L)
    {
        XTopRight = X;
        YTopRight = Y;
        Width = W;
        Length = L;     
    } 
    private double GetXTR()
    {
        return XTopRight;
    }
    private double GetYTR()
    {
        return YTopRight;
    }
    private double GetWidth()
    {
        return Width;
    }
    private double GetLength()
    {
        return Length;
    }

    
    public void CreateSquare()
    {
		
    }

 }
