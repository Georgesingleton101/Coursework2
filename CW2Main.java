public class CW2Main
{
     public static void main(String[] arguments)
    {
        Board GameBoard = new Board(1);
        GameBoard.SetLilyPads();
        GameBoard.FrogPostions(4,2,6,8,16,18,25,25);
        GameBoard.SetOnClick();
    }
}