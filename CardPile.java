import java.util.*;
/*
   Caitlin Baker
   CS 110
   Card Pile Class
*/

/**
   The functions of each players card pile.
*/

public class CardPile
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
}