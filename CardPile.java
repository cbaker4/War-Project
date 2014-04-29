import java.util.*;
/*
   Caitlin Baker
   CS 110
   Card Pile Class
*/

/**
   The functions of each players card pile.
*/

public class CardPile extends Deck1 implements Deck1Interface
{
   private ArrayList<Card> cardPile;
   
   // constructor to create a new pile of cards
   public CardPile()
   {
      cardPile = new ArrayList<Card>();
   }
   
   /**
      @param c Parameter of the card to add to the
               pile.
   */
   public void addCard(Card c)
   {
      cardPile.add(c);
   }
   
   /**
      @return Returns the top card
   */
   public Card flipCard()
   {
      return cardPile.remove(0);
   }
   
   /**
      @return Returns the size of the deck
   */
   public int size()
   {
      return cardPile.size();
   }
   
   /**
      Determines if the deck is empty
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
   /**
      shuffles the deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
}