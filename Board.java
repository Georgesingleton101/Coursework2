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
    static GraphicsConfiguration Board;
    public Board()
    {
        
    }
    public void Show()
    {
        JFrame frame = new JFrame(Board);	
        frame.setSize(700, 600);
		frame.setLayout(null); 
        JButton b=new JButton();   
        JButton c=new JButton();    
		b.setBounds(0,0,140,120);    
        c.setBounds(140,0,140,120);
        Icon Water =new ImageIcon("water.png");
        b.setIcon(Water);
        c.setIcon(Water);
        frame.add(b);
        frame.add(c);
        frame.setVisible(true);
       
    }
}