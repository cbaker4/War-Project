/*
   Caitlin Baker
   CS 110
   War Class
*/

/**
   The class where the actual game is played internally. Determines
   the winners.
*/

public class War
{
   private Deck1 warD;
   private CardPile cp1 = new CardPile();
   private CardPile cp2 = new CardPile();
   private Card c1, c2, c3, c4, c5, c6;
   
   /**
      constructor
      Creates a new deck for war
   */
   public War(Deck1 d)
   {
      warD = d;
      warD.shuffle();
   }
   
   // deck for each player
   public void playerDeck()
   {
      for (int i=0; i < warD.cardsRemaining(); i += 2)
         cp1.addCard(warD.dealCard());
         
      for (int i=0; i < warD.cardsRemaining(); i += 2)
         cp2.addCard(warD.dealCard());
   }
   
   public Card flipCard1()
   {
      // flips a card for each player  
      c1 = new Card(cp1.flipCard());
      return c1;
      
   }
   
   public Card flipCard2()
   {
      c2 = new Card(cp2.flipCard());
      return c2;
   }
   
   public void wFlipCard()
   {
      c3 = new Card(cp1.flipCard());
      c4 = new Card(cp2.flipCard());
      c5 = new Card(cp1.flipCard());
      c6 = new Card(cp2.flipCard());
   }
   
   /**
      @return str Returns a string depending on who won.
   */
   public int play()
   { 
      // flips a card for each player  
      //c1 = new Card(cp1.flipCard());
      //c2 = new Card(cp2.flipCard());
      flipCard1();
      flipCard2();
      
      int rw;
      
      // determines who wins and adds to the pile
      if (c1.getRank() < c2.getRank())
      {
         rw = 2;
         cp2.addCard(c2);
         cp2.addCard(c1);
      }
      else if (c1.getRank() > c2.getRank())
      {
         rw = 1;
         cp1.addCard(c1);
         cp1.addCard(c2);
      }
      else
      {
         // call war
         rw = 0;
         war();
      }
      
      return rw;      
   }
   
   // method for war
   public int war()
   {
      int w2;
      
      wFlipCard();
      //Card c3 = new Card(cp1.flipCard());
      //Card c4 = new Card(cp2.flipCard());
      //Card c5 = new Card(cp1.flipCard());
      //Card c6 = new Card(cp2.flipCard());
      
      if (c5.getRank() < c6.getRank())
      {
         w2 = 2;
         cp2.addCard(c3);
         cp2.addCard(c4);
         cp2.addCard(c5);
         cp2.addCard(c6);
      }
      else if (c5.getRank() > c6.getRank())
      {
         w2 = 1;
         cp1.addCard(c3);
         cp1.addCard(c4);
         cp1.addCard(c5);
         cp1.addCard(c6);
      }
      else
      {
         // call war
         w2 = 0;
         war();
      }
      
      return w2;
   }
   
   /**
      Determines if the deck is empty
   */
   public boolean gameOver()
   {
      boolean status;
      
      if (cp1.size() == 0 || cp2.size() == 0)
         status = true;
      else
         status = false;
      
      return status;
   }
   
   /**
      @return str1 Returns the winner of the whole game
   */
   public int determineWinner()
   {
      int dw;
      
      if (cp1.size() > cp2.size())
         dw = 1;
      else if (cp1.size() < cp2.size())
         dw = 2;
      else
         dw = 0; 
      return dw;  
   } 
   
   public static void main(String [] args)
   {
      Deck1 d = new Deck1();
      War game = new War(d);
      
      game.playerDeck();
      
      while (game.gameOver() == false)
         {
            game.play();;
            if (game.play() == 1)
               System.out.println("Player 1 wins"); 
            else if (game.play() == 2)
               System.out.println("Player 2 wins");
            else
               System.out.println("War");
            
            
         }
         if (game.gameOver() == true)
         {
            if(game.determineWinner() == 1)
               System.out.println("Player 1 wins game");
            else if(game.determineWinner() == 2)
               System.out.println("Player 2 wins game");
            else if(game.determineWinner() == 0)
               System.out.println("Tie");
         } 

   }
}