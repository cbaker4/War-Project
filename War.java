import java.util.Random;
import java.util.ArrayList;
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
   private CardPile wp, wp1;
   private Card c1, c2, c3, c4, c5, c6;
   private int w2 = 0;
   
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
   
   /**
      @return c1 returns the flipped card
   */
   public Card flipCard1()
   {
      // flips a card for player  
      c1 = new Card(cp1.flipCard());
      return c1;
      
   }
   
   /**
      @return c2 returns the flipped card
   */
   public Card flipCard2()
   {
      c2 = new Card(cp2.flipCard());
      return c2;
   }
   
   /**
      @return wp returns the flipped card for a war
   */
   public CardPile wFlipCard()
   {
      wp = new CardPile();
      c3 = new Card(cp1.flipCard());
      c4 = new Card(cp2.flipCard());
      
      
      wp.addCard(c3);
      wp.addCard(c4);
      
      
      return wp;
   }
   
   public CardPile wFlipCard2()
   {
      wp1 = new CardPile();
      c5 = new Card(cp1.flipCard());
      c6 = new Card(cp2.flipCard());
      
      wp.addCard(c5);
      wp.addCard(c6);
      
      return wp1;
   }
   
   /**
      @return str Returns a string depending on who won.
   */
   public void play()
   { 
      // flips a card for each player  
      if (cp1.size() != 0)
         flipCard1();
      if (cp2.size() != 0)
         flipCard2();
    }
    
    /**
      @return int who won the round
    */ 
    public int winner()
    {
      // determines who wins and adds to the pile
      if (c1.getRank() < c2.getRank())
      {
         
         cp2.addCard(c2);
         cp2.addCard(c1);
         return 2;
      }
      else if (c1.getRank() > c2.getRank())
      {
         
         cp1.addCard(c1);
         cp1.addCard(c2);
         return 1;
      }
      else
      {
         // call war
         war();
         return 0;
      }
   }
         

   
   // method for war
   public void war()
   {
      if (cp1.size() != 0)
         wFlipCard();
      if (cp2.size() != 0)
         wFlipCard2();
      wWinner();
   }
   
   /**
      @return int who won the war
    */
   public int wWinner()
   {
      // determine winner
      if (c5.getRank() < c6.getRank())
      {
         
         cp2.addCard(c3);
         cp2.addCard(c4);
         cp2.addCard(c5);
         cp2.addCard(c6);
         w2 = 2;
      }
      else if (c5.getRank() > c6.getRank())
      {
         
         cp1.addCard(c3);
         cp1.addCard(c4);
         cp1.addCard(c5);
         cp1.addCard(c6);
         w2 = 1;
      }
      else
         w2 = 0;
      return w2;
   }
   
   /**
      @return status Determines if the deck is empty
   */
   public boolean isEmpty()
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
      if (cp1.size() > cp2.size())
         return 1;
      else
         return 2;  
   } 
   
   // main method to test war game
   public static void main(String [] args)
   {
      Deck1 d = new Deck1();
      War game = new War(d);
      
      game.playerDeck();
      
      while (game.isEmpty() == false)
      {
         game.play();
         if (game.winner() == 1)
            System.out.println("Player 1 wins"); 
         else if (game.winner() == 2)
            System.out.println("Player 2 wins");
         else
            System.out.println("War");     
      }
         
      if(game.determineWinner() == 1)
         System.out.println("Player 1 wins game");
      else if(game.determineWinner() == 2)
         System.out.println("Player 2 wins game");
          

   }
}