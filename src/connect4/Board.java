package connect4;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 8;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private  static int row;
    private  static int column; 
     private  static int rowWin1;
    private  static int columnWin1;
     private  static int rowWin2;
    private  static int columnWin2;
     private  static int rowWin3;
    private  static int columnWin3;
     private  static int rowWin4;
    private  static int columnWin4;
    private enum WinState {NO_WIN, WIN_P1, WIN_P2,TIE} // no win = playing
    private static WinState winner;
     private static int player1total = 0;
     private static  int player1value = 0;
      private static int player2total = 0;
     private static  int player21value = 0;
//       private static boolean done1;
//           private static boolean done2;
     
    //CheckWin now checks the whole board.
     public static int getPlayerTotal(){
      if(Player.GetCurrentPlayer().getColor() == Color.black)
          return player1total;
      else 
          return player2total;
     }
    public static boolean CheckWin()
    {
        int numConsecutive = 0;
        Color colorMatch = null;
         int NUM_CONNECT =4;
      
//Check for horizontal win.        
        for (int row=0;row<NUM_ROWS;row++)
        {
            for (int col=0;col<NUM_COLUMNS;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                    player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;   
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT)
                    {
                         rowWin4 = row;
                   columnWin4 = col;
                       if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);
                        
                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                     
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();

                    colorMatch = board[row][col].getColor();
                    rowWin1 = row;
                   columnWin1 = col;
                }        
             
            }            
            colorMatch = null;
            numConsecutive = 0; 
            player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
            
        }
        
//Check for vertical win.                  
         

 
 for (int col=0;col<NUM_COLUMNS;col++)
        {
            for (int row=0;row<NUM_ROWS;row++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                    player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;  
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                     if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT)
                    {
                                rowWin4 = row;
                                columnWin4 = col;
                        if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);
                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();

                    colorMatch = board[row][col].getColor();
                            rowWin1 = row;
                   columnWin1 = col;
                }        
             
            }            
            colorMatch = null;
            numConsecutive = 0; 
             player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
        }
 


//Check for diagonal win to the right and up.
        colorMatch = null;
        numConsecutive = 0;
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            int row = zrow;
            for (int col=0;row>=0;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                    player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT)
                    {
                                rowWin4 = row;
                   columnWin4 = col;
                        if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                     if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                            rowWin1 = row;
                   columnWin1 = col;
                }        
             

                row--;
            }
            colorMatch = null;
            numConsecutive = 0;    
             player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
        }
        
        colorMatch = null;
        numConsecutive = 0;
        for (int zcol=1;zcol<NUM_COLUMNS;zcol++)
        {
            int col = zcol;
            for (int row=NUM_ROWS-1;col<NUM_COLUMNS;row--)
            {              

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                    player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;  
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT)
                    {
                                rowWin4 = row;
                   columnWin4 = col;
                        if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                   if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                            rowWin1 = row;
                   columnWin1 = col;
                }        
             
     
                col++;
            }
            colorMatch = null;
            numConsecutive = 0; 
             player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
        }
        
//Check for diagonal win to the right and down.
        colorMatch = null;
        numConsecutive = 0;  
        for (int zrow=NUM_ROWS-1;zrow>=0;zrow--)
        {
            int row = zrow;
            for (int col=0;row<NUM_ROWS;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                    player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;  
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                    if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT)
                    {
                                rowWin4 = row;
                   columnWin4 = col;
                        if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                 if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                            rowWin1 = row;
                   columnWin1 = col;
                }        
              
     
                row++;
            }
            colorMatch = null;
            numConsecutive = 0;     
             player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;

        }
        
        colorMatch = null;
        numConsecutive = 0;
        for (int acol=1;acol<NUM_COLUMNS;acol++)
        {
            int col = acol;
            for (int row=0;col<NUM_COLUMNS;row++)
            {              

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    colorMatch = null;
                 player1value = 0;
                player21value = 0;
                player1total = 0;
                player2total = 0;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;  
                    if(numConsecutive == 2){
                        rowWin2 = row;
                   columnWin2 = col;
                    }
                    if(numConsecutive == 3){
                        rowWin3 = row;
                   columnWin3 = col;
                    }
                  if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT)
                    {
                                rowWin4 = row;
                   columnWin4 = col;
                        if(board[row][col].getColor() == Color.red)
                     player1total = player1value;
                    else 
                        player2total = player21value;
                        return(true);

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                 if(board[row][col].getColor() == Color.red)
                     player1value  += board[row][col].getValue();
                    else 
                        player21value += board[row][col].getValue();
                        
                    colorMatch = board[row][col].getColor();
                            rowWin1 = row;
                   columnWin1 = col;
                }        
                   
                
                col++;
            }
            colorMatch = null;
            numConsecutive = 0;
             player1value = 0;
            player21value = 0;
            player1total = 0;
            player2total = 0;
        }
             
        return (false);
    }        
    

         public static void RemovePiece(int xPixel, int yPixel){
         int ydelta = Window.getHeight2()/NUM_ROWS; //height of sqaure
    int xdelta = Window.getWidth2()/NUM_COLUMNS;
    column = xPixel / xdelta;
     row = yPixel / ydelta;
        if (board[row][column] == null)
           return;
        while(row > 0){
        board[row][column] = board[row-1][column];
        row--;
        if(board[row+1][column] != null)
        board[row][column] = null;
        }
        
        
}
 public static void FlipPiece(int xPixel, int yPixel){
         int ydelta = Window.getHeight2()/NUM_ROWS; //height of sqaure
    int xdelta = Window.getWidth2()/NUM_COLUMNS;
    column = xPixel / xdelta;
     row = yPixel / ydelta;
     Piece tempboard[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
     
      int theRow = NUM_ROWS-1;
      int numPieces = 0;
      int numLoop = 0;
      int loop = 0;
      if (board[row][column] == null)
           return;
      while(theRow > -1 && board[theRow][column] != null){
               numPieces++;
               theRow--;
           }
      
      int rowBottom = NUM_ROWS-1;
      int rowTop = NUM_ROWS - numPieces;
      numLoop = numPieces/2;
      
         while(loop < numLoop) {
               tempboard[rowBottom][column] = board[rowBottom][column];
                board[rowBottom][column] =   board[rowTop][column];
                board[rowTop][column] = tempboard[rowBottom][column];
               rowBottom--;
               rowTop++;
               loop++;
           }
 }
  
public static void AddPiece(int xPixel, int yPixel){
    if (winner != WinState.NO_WIN)
        return;
         int ydelta = Window.getHeight2()/NUM_ROWS; //height of sqaure
    int xdelta = Window.getWidth2()/NUM_COLUMNS;
    column = xPixel / xdelta;
     row = yPixel / ydelta;
     int theRow =  NUM_ROWS-1;
        while (theRow != -1 && (board[theRow][column] != null) )
        {
            theRow--;
            
        }
        if (theRow == -1)
            return;      
        board[theRow][column] = new Piece(Player.GetCurrentPlayer().getColor());
        
        
      if(CheckWin()){
          if(Player.GetCurrentPlayer().getColor() == Color.red)
        winner = WinState.WIN_P1;
          else 
               winner = WinState.WIN_P2;
      }
        Player.SwitchTurn();

}
    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;  
       winner   = WinState.NO_WIN; 
//          done1 = false;
//         done2 = true;
    }

    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS; //height of sqaure
        int xdelta = Window.getWidth2()/NUM_COLUMNS; // width of sqaure
 
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        if(CheckWin()){
           board[rowWin1][columnWin1].drawWin(g, rowWin1, columnWin1,xdelta, ydelta);
             board[rowWin2][columnWin2].drawWin(g, rowWin2, columnWin2,xdelta, ydelta);
              board[rowWin3][columnWin3].drawWin(g, rowWin3, columnWin3,xdelta, ydelta);
               board[rowWin4][columnWin4].drawWin(g, rowWin4, columnWin4,xdelta, ydelta);
        }
         
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null){
                     
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
                }
            }
        }  
           
      
    }
}
//public static void Animate(){
//               done1 = false;
//           board[row][column] = null;
//             if(row < NUM_ROWS-1 && (board[row+1][column] == null)){
//                     row++;
//              board[row][column] = new Piece(Color.BLACK);
//              done1 = true;
//             }
//             board[row][column] = new Piece(Color.BLACK);
//          }
//          public static void Animate2(){
//               done2 = true;
//           board[row][column] = null;
//             if(row < NUM_ROWS-1 && (board[row+1][column] == null)){
//                     row++;
//              board[row][column] = new Piece(Color.RED);
//                done2 = false;
//             }
//             board[row][column] = new Piece(Color.RED);
//              
//          }
//public static void AddPiece(int xPixel, int yPixel){
// if(!done2 || done1)
//        return;
//    column = xPixel / 75;
//    row = yPixel / 67;
//    if (player1 == true && board[row][column] == null) {
//             board[row][column] = new Piece(Color.BLACK);
//    
//    player1 = false;
//    player2 = true;
//             
//    
//    }
//     if (player2 == true && board[row][column] == null ){
//    board[row][column] = new Piece(Color.RED);
//      player2 = false;
//       player1 = true;
//     }
//    
//}