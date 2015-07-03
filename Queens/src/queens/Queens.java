package queens;



public class Queens implements QueensInterface
{
 public final static int SIZE=8;

 
 public void initBoard(char[][] board)
 {
     for (int i=0; i < SIZE; i++)
         for (int j=0; j < SIZE; j++)
             board[i][j] = '-';
 }

 
 public void displayBoard(char[][] board)
 {
     for (int i=0; i < SIZE; i++)
     {
         for (int j=0; j < SIZE; j++)
             System.out.print(board[i][j] + " ");
         System.out.println();
     }
     System.out.println();
 }

// megnezi, hogy az aktuális poziciót
 public boolean safe(char[][] tabla, int sor, int oszlop)
 {
     int i,j;

     // oszlop
     for (i=0; i<SIZE; i++)
         if (tabla[i][oszlop] == 'Q')
             return false;

     // sor
     for (j=0; j<SIZE; j++)
         if (tabla[sor][j] == 'Q')
             return false;

     // le és jobbra
     for (i=sor, j=oszlop; i < SIZE && j < SIZE; i++, j++)
         if (tabla[i][j] == 'Q')
             return false;

     // fel balra
     for (i=sor, j=oszlop; i >=0 && j >=0 ; i--, j--)
         if (tabla[i][j] == 'Q')
             return false;

     // fel jobbra
     for (i=sor, j=oszlop; i >=0 && j < SIZE; i--, j++)
         if (tabla[i][j] == 'Q')
             return false;

     // le és balra
     for (i=sor, j=oszlop; i < SIZE && j >=0 ; i++, j--)
         if (tabla[i][j] == 'Q')
             return false;

     // megfelelo
     return true;
 }

 // felölti a táblát
 public boolean completeBoard(char[][] board)
 {

     // kiralynok szama
     int numQueens = 0;
     for (int i=0; i < SIZE; i++)
         for (int j=0; j < SIZE; j++)
             if (board[i][j] == 'Q')
                 numQueens++;

     if (numQueens == SIZE)
         return true;

     // kiralynok hozzaadasa ha meg nincs fennt 8 kiralyno
     for (int i=0; i < SIZE; i++)
         for (int j=0; j < SIZE; j++)
             if (safe(board,i,j))
             {
                 board[i][j] = 'Q';
                 if (completeBoard(board))
                     return true;
                 else
                     board[i][j] = '-';
             }
     
     // nem talalt megoldast
     return false;
 }

 public static void main(String[] args)
 {
	 Queens q = new Queens();
     char[][] tabla = new char[SIZE][SIZE];
     q.initBoard(tabla);
     boolean helyes = q.completeBoard(tabla);
     if (helyes)
     {
         System.out.println("Megoldva!");
         q.displayBoard(tabla);
     }
     else
     {
         System.out.println("Nincs megoldás.");
     }
 }
}
