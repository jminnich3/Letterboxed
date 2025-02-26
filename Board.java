import java.util.ArrayList;

public class Board {

    /*

Board class
  store board in 2D 4*x array (4 sides of x length)
    board[4][x]
      where columns contain our board side letters
  getUsed()
    returns a list of used letters
  getUnused()
    returns a list of unused letters
  getUnusedCount()
    return number of letters left to use
    */

    private int sideLength;
    private char[][] board;
    ArrayList<Character> unusedLetters;

    /**
     *
     */
    public Board(int sideLength, String lineFromFile)
    {
        this.sideLength = sideLength;
        unusedLetters = new ArrayList<Character>();
        board = new char[4][sideLength];

        int boardRow = 0;
        int boardCol = 0;
        for(int i = 0; i < lineFromFile.length(); i++)
        {
            if(lineFromFile.charAt(i) == ' ')
            {
                boardRow++;
                boardCol = 0;
            }
            else
            {
                unusedLetters.add(lineFromFile.charAt(i));
                board[boardRow][boardCol] = lineFromFile.charAt(i);
                boardCol++;
            }
        }
    }

    public int getUnusedCount()
    {
        return unusedLetters.size();
    }

    public void printFormattedBoard()
    {
        //print top row
        System.out.print(" ");
        for(int i = 0; i < board[0].length; i++)
        {
            System.out.print(board[0][i] + " ");
        }
        System.out.println();

        //print left and right sides
        for(int i = 0; i < board[0].length; i++)
        {
            System.out.print(board[1][i]);
            for(int j = 0; j < sideLength - 1; j++)
            {
                System.out.print("  ");
            }
            System.out.print(" ");
            System.out.print(board[2][i]);
            System.out.println();
        }

        //print bottom row
        System.out.print(" ");
        for(int i = 0; i < board[0].length; i++)
        {
            System.out.print(board[3][i] + " ");
        }
    }

}
