
import javax.swing.JButton;

public class TicTacToeGame extends Board {

   char tl;
   char tm;
   char tr;
   char ml;
   char mm;
   char mr;
   char bl;
   char bm;
   char br;
   
   int turnsTaken;
 
   TicTacToeGame(String s) {
      super(s);
      turnsTaken = 0;
   }

// TODO Write a method that will update the appropriate variables for the board positions
// TODO you defined above.

   // TODO write the turn method - that completes an entire turn.  You may
  //  TODO need to figure out which button the user clicked on, if you do, I recommend
  //  TODO using the buttonRow and buttonColumn methods.
  
   @Override
   public void turn(JButton button) {
	   button.setText(""+getWhoseTurn());
	   turnsTaken = turnsTaken + 1;
	   
	   //If statements which link the buttons to the fields keeping track of who has place where
	   if(buttonRow(button) == 0 && buttonCol(button) == 0) { //0,0 on the board is the top left piece
		   tl = getWhoseTurn(); //set the top left piece to whoever's turn it is
		   System.out.println(tl);
	   }
	   /* 8 more if statements for all the buttons/pieces on the board*/
	 
   
	   // for(int r = 0; r < ROWS; r++) = whoseTurn;
	   //  for(int c = 0; c < COLS; c++) = whoseTurn;       
	   if(turnsTaken >= 5) {
		   if( winner() ) { System.out.println("Game Won"); }
	   }
      
	   if(turnsTaken >= 9) { System.out.println("Game Lost"); }
	   if( getWhoseTurn() == 'x') {
		   setWhoseTurn('o');
	   } else {
         setWhoseTurn('x');
      }
      
   }
   
   // TODO write a method to handle the end of the game.  I recommend using
   // TODO one parameter to indicate if the game is won or lost
   
   // TODO Write a method named reset() that will reset all of the necessary variables
   
   public void reset() {
   
      super.clearBoard();  // This will make the board display all spaces
      
      turnsTaken = 0;
   }
   
   
   private boolean winner(){
	   char whoseTurn = super.getWhoseTurn();
	   System.out.println(whoseTurn);
	   System.out.println(tl);
	   if(whoseTurn == tl && whoseTurn == tm && whoseTurn == tr) {
         return(true);
	   }
     
	   if(whoseTurn == ml && whoseTurn == mm && whoseTurn == mr) {
         return(true);
      }
      
      if(whoseTurn == tl && whoseTurn == ml && whoseTurn == bl)
      {
         return(true);
      }
      
      if(whoseTurn == tm && whoseTurn == mm && whoseTurn == bm)
      {
         return(true);
      }
      
      if(whoseTurn == tr && whoseTurn == mr && whoseTurn == br)
      {
         return(true);
      }
      
      if(whoseTurn == tl && whoseTurn == mm && whoseTurn == br)
      {
         return(true);
      }
      
      if(whoseTurn == tr && whoseTurn == mm && whoseTurn == bl)
      {
         return(true);
      }
     
      if(whoseTurn == bl && whoseTurn == bm && whoseTurn == br)
      {
         return(true);
      }
      return(false);
   
   }
     
   public static void main(String[] args) {     
      TicTacToeGame b = new TicTacToeGame("TIC TAC TOE");

      
         //Checking Win Method Below
    /*  b.tl = 'x';
      b.tm = 'o';
      b.tr = 'o';
      b.ml = 'x';
      b.mm = 'o';
      b.mr = 'x';
      b.bl = 'x';
      b.bm = 'o';
      b.br = 'x';
     
      System.out.println(b.winner());*/
   
    
   }
}