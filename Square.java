/**
*This class models a simple square. When combined with the Board class instances of the square can displayed on screen.
*@author George Singleton
*@version 2.2
*/
public class Square 
{
    private int XTopRight; //The x cordinate of the top right of this square
    private int YTopRight; //The y cordinate of the top right of this square
    private int Width; //The width of this square
    private int Length; //the length of this square
    private String Type; //the type of this square
    /**
    *
    *@param XTR The top right corners x cordinate(in pixels)
    *@param YTR The top right corners y cordinate(in pixels)
    *@param Wid The width of the sqaure(in pixels)
    *@param Len The lenth of this square(in pixels)
    *@param Typ The type of this square(e.g. LilyPad)
    */
    public Square(int XTR, int YTR,int Wid, int Len,String Typ)
    {
        XTopRight = XTR;
        YTopRight = YTR;
        Width = Wid;
        Length = Len;  
        Type = Typ;   
    } 
/**
	* Obtains this sqaures top right corners x cordinate
	* @return the y coordinate of the top right of this sqaure
	*/
    public int GetXTR()
    {
        return XTopRight;
    }
    /**
	* Obtains this sqaures top right corners y cordinate
	* @return the y coordinate of the top right of this sqaure
	*/
    public int GetYTR()
    {
        return YTopRight;
    }
    /**
	* Obtains the width of this square
	* @return the width of this square
	*/
    public int GetWidth()
    {
        return Width;
    }
    /**
	* Obtains the length of this square
	* @return the length of this square
	*/
    public int GetLength()
    {
        return Length;
    }
    /**
	* Obtains the type of this square
	* @return the type of this square
	*/
    public String GetType()
    {
        return Type;
    }
    /**
	* Changes the type of this sqaure to the new one passed in
	* @param NewType the new type of this sqaure  
	*/
    public void ChangeType(String NewType)
    {
        Type = NewType;
    }
    /**
	* Moves the frog character from this selected square to the passed in square
	* @param Square1 the square which the frog is being movied to 
	*/
    public void MoveTo(Square Square1)
    {
        //Type of currentpositon of frog checked to see what the type of the arranged position of the frog should be.
        if (Type == "GreenFrog")
        {
            Square1.ChangeType("GreenFrog");
        }
        else if(Type == "RedFrog")
        {
            Square1.ChangeType("RedFrog");
        }
        Type = "LilyPad";
    }
 }
