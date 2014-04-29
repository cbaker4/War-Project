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
   private Card c1, c2, c3, c4;
   
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
      @return str Returns a number depending on who won.
   */
   public int game()
   { 
      // flips a card for each player  
      c1 = new Card(cp1.flipCard());
      c2 = new Card(cp2.flipCard());
      
      int str;
      
      // determines who wins and adds to the pile
      if (c1.getRank() < c2.getRank())
      {
         str = 2;
         cp2.addCard(c2);
         cp2.addCard(c1);
      }
      else if (c1.getRank() > c2.getRank())
      {
         str = 1;
         cp1.addCard(c1);
         cp1.addCard(c2);
      }
      else
      {
         str = 0;
         c3 = new Card(cp1.flipCard());
         c4 = new Card(cp2.flipCard());
         if (c3.getRank() < c4.getRank())
         {
            str = 2;
            cp2.addCard(c2);
            cp2.addCard(c1);
            cp2.addCard(c3);
            cp2.addCard(c4);
         }
         else if (c3.getRank() > c4.getRank())
         {
            str = 1;
            cp1.addCard(c2);
            cp1.addCard(c1);
            cp1.addCard(c3);
            cp1.addCard(c4);
         }
         else
            str = 0;
      }
      
      return str;      
   }
   
   /**
      @return str1 Returns the winner of the whole game
   */
   public String determineWinner()
   {
      String str1;
      
      if (cp1.size() > cp2.size())
         str1 = "Player 1 Wins Game!";
      else if (cp1.size() < cp2.size())
         str1 = "Player 2 Wins Game!";
      else
         str1 = "Tie Game"; 
      return str1;  
   } 
}