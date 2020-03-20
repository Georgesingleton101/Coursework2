public class CW2Main
{
/**
*This class is the main class which utilises the other classes to run the game.
*@author George Singleton
*@version 2.2
*/
    public static void main(String[] arguments)
    {
        Board GameBoard = new Board(1);
        GameBoard.SetLilyPads();
        GameBoard.FrogPostions(4,2,6,8,16,18,25,25);
        GameBoard.SetOnClick();
    }
}