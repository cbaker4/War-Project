/*
   Caitlin Baker
   CS 110
   War Class
*/

/**

*/

public class War
{
   private Deck1 warD;
   private CardPile cp1 = new CardPile();
   private CardPile cp2 = new CardPile();
   private Card c1, c2, c3, c4;
   
   public War(Deck1 d)
   {
      warD = d;
      warD.shuffle();
   }
   
   public String game()
   {
      for (int i=0; i < warD.cardsRemaining(); i += 2)
         cp1.addCard(warD.dealCard());
         
      for (int i=0; i < warD.cardsRemaining(); i += 2)
         cp2.addCard(warD.dealCard());
         
      c1 = new Card(cp1.flipCard());
      c2 = new Card(cp2.flipCard());
      
      String str;
   
      if (c1.getRank() < c2.getRank())
      {
         str = "Player 2 wins";
         cp2.addCard(c2);
         cp2.addCard(c1);
      }
      else if (c1.getRank() > c2.getRank())
      {
         str = "Player 1 wins";
         cp1.addCard(c1);
         cp1.addCard(c2);
      }
      else
      {
         str = "War";
         c3 = new Card(cp1.flipCard());
         c4 = new Card(cp2.flipCard());
         if (c1.getRank() < c2.getRank())
         {
            str = "Player 2 wins";
            cp2.addCard(c2);
         }
         else if (c1.getRank() > c2.getRank())
         {
            str = "Player 1 wins";
            cp1.addCard(c1);
         }
         else
            str = "Tie";
      }
      
      return str;      
   }
   
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